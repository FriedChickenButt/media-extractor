package com.fcb.youtubelink;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.net.*;
import java.lang.*;
import java.net.URL;
import java.nio.charset.Charset;

class YTResult {
    int width, height;
    String link, type, format;

    YTResult(int width, int height, String type, String format, String link) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.format = format;
        this.link = link;
    }

    public ArrayList<String> getData() {
        ArrayList<String> res = new ArrayList<>();
        res.add(Integer.toString(width));
        res.add(Integer.toString(height));
        res.add(type);
        res.add(format);
        res.add(link);
        return res;
    }
}

class YLink {
    public static void main(String[] args) {
        try {
            URL url = new URL(args[0]);
            System.out.println(url);

            // Copied from <https://stackoverflow.com/questions/1381617/simplest-way-to-correctly-load-html-from-web-page-into-a-string-in-java> upto line 26
            // Downloads webpage
            URLConnection con = url.openConnection();
            Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
            Matcher m = p.matcher(con.getContentType());
            String charset = m.matches() ? m.group(1) : "ISO-8859-1";
            Reader r = new InputStreamReader(con.getInputStream(), charset);
            StringBuilder buf = new StringBuilder();
            while (true) {
              int ch = r.read();
              if (ch < 0)
                break;
              buf.append((char) ch);
            }
            String str = buf.toString();
            // 

            // Gets JS code containing video urls
            String str1 = str.substring(str.indexOf("<div id=\"player-api\""));
            str1 = str1.substring(str1.indexOf("</script>") + 10);
            str1 = str1.substring(0, str1.indexOf("</script>") + 10);
            //

            // URL decoding
            str1 = URLDecoder.decode(str1, "UTF-8");
            //

            // Removing \u0026, \\u0026, \ and converting str1 to UTF-8
            str1 = str1.replace("\\\\u0026","&");
            str1 = str1.replace("\\u0026","&");
            str1 = str1.replace("\\","");
            byte b[] = new byte[str1.length()];
            b = str1.getBytes(Charset.forName("UTF-8"));
            str1 = new String(b, Charset.forName("UTF-8"));
            //

            // ArrayList to store the YTResult data (may need to run this a few more times)
            ArrayList<YTResult> ytResults = new ArrayList<>();
            //

            // Searching for links (Regex didn't work)
                // Links do not work for some reason
                // for(int i = str1.indexOf("&url="); i > 0; i = str1.indexOf("&url=", i + 1)) {
                //     System.out.println(str1.substring(i, str1.indexOf(';', i)));
                // }            
            for(int i = str1.indexOf("\"url\":\""); i > 0; i = str1.indexOf("\"url\":\"", i + 1)) {
                if(str1.charAt(i + 7) != 'h') // Elimiating non-urls
                    continue;
                int widthIndex = str1.indexOf("\"width\"", i) + 8;
                int heightIndex = str1.indexOf("\"height\"", i) + 9;
                int heightEndIndex = Math.min(str1.indexOf('\"', heightIndex) - 1 , str1.indexOf('}', heightIndex));
                int typeIndex = str1.indexOf("mime=", i) + 5;
                int typeEndIndex = str1.indexOf("/", typeIndex);
                int formatIndex = typeEndIndex + 1;
                int formatEndIndex = str1.indexOf("&", formatIndex);


                int width = Integer.parseInt(str1.substring(widthIndex, str1.indexOf('\"', widthIndex) - 1));
                int height = Integer.parseInt(str1.substring(heightIndex, heightEndIndex));
                String type = str1.substring(typeIndex, typeEndIndex);
                String format = str1.substring(formatIndex, formatEndIndex);
                String link = str1.substring(i + 7, str1.indexOf('\"', i + 10));
                if(!type.contains("audio") && !type.contains("video")) {
                    type = "thumbnail";
                    format = "image";
                }

                YTResult newResult = new YTResult(width, height, type, format, link);
                ytResults.add(newResult);
            }
            //

            for(int i = 0; i < ytResults.size(); i++) {
                System.out.println(ytResults.get(i).getData());
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}