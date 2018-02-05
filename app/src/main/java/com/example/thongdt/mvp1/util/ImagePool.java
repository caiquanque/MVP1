package com.example.thongdt.mvp1.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by thong.dt on 02/02/2018.
 */

public class ImagePool {

    private static List<String> images = new ArrayList<>();

    static {
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");
        images.add("https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg");

    }

    public static String getImage() {
        Random random = new Random();
        return images.get(Math.abs(random.nextInt() % images.size()));
    }
}
