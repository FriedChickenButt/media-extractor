package com.fcb.youtubelink;

import com.fcb.youtubelink.*;
import java.util.*;

class Test {
    public static void main(String[] args) {
        ArrayList<YTResult> yt = new ArrayList<>();
        YLink yLink = new YLink("https://www.youtube.com/watch?v=3CZYMfE5vLM");
        yt = yLink.getAllLinks();
        for(YTResult res : yt) {
            System.out.println(res.getData());
        }
    }
}