/**
 * This class stores the details of the link
 */

package com.fcb.youtubelink;

import java.util.ArrayList;

public class YTResult {
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