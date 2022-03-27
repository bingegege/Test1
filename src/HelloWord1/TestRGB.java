package HelloWord1;

/**
 *
 * @author zhenghuan
 * @date 2021/4/21
 */
/*
 * TestRGB.java
 * Copyright 2021 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRGB {
    // 颜色标准数（固定差值）
    public static final float colorNum = 51.0f;

    public static final int colorAmount=4;
    // 颜色标准（倍数关系）
    public static final Map<Integer, String> colorStandard = new HashMap<>();
    static {
        colorStandard.put(0, "00");
        colorStandard.put(1, "33");
        colorStandard.put(2, "66");
        colorStandard.put(3, "99");
        colorStandard.put(4, "cc");
        colorStandard.put(5, "ff");
    }

    // 十进制转十六进制
    @SuppressWarnings({ "static-access", "deprecation" })
    public static String tenToHex(int x) {
        Integer ten = x;
        String hex = ten.toHexString(ten);
        return hex;
    }

    // 十六进制转十进制
    public static Integer hexToTen(String hex) {
        Integer x = Integer.parseInt(hex, 16);
        return x;
    }

    public static int[] changeToRgbArr(final String hexStr){
        if(hexStr==null){
            return null;
        }
        final int[] rgbArr=new int[3];
        rgbArr[0]=hexToTen(hexStr.substring(0,2));
        rgbArr[1]=hexToTen(hexStr.substring(2,4));
        rgbArr[2]=hexToTen(hexStr.substring(4));
        return rgbArr;
    }

    // 将十进制形式rgb转为符合标准颜色的十六进制字符串形式
    public static String changeRgb(int r, int g, int b) {
        // 通过颜色标准数计算颜色标准key
        int rk = Math.round(Float.parseFloat(r + "") / colorNum);
        int gk = Math.round(Float.parseFloat(g + "") / colorNum);
        int bk = Math.round(Float.parseFloat(b + "") / colorNum);
        // 通过颜色标准key取出标准颜色
        String rs = colorStandard.get(rk);
        String gs = colorStandard.get(gk);
        String bs = colorStandard.get(bk);
        return rs + gs + bs;
    }

    public static String changeRgb1(String str) {
        // 通过颜色标准key取出标准颜色
        String rs = colorStandard.get(Integer.valueOf(str.substring(0,1)));
        String gs = colorStandard.get(Integer.valueOf(str.substring(1,2)));
        String bs = colorStandard.get(Integer.valueOf(str.substring(2,3)));
        return rs + gs + bs;
    }

    // 将BufferImage取出来的rgb int 值转换为三位数的rgb
    public static int[] changeToRgb(final int pixel) {
        final int[] rgb = new int[3];
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);
        return rgb;
    }

    /**
     * 获取图片主要颜色
     * @param input
     */
    @SuppressWarnings("deprecation")
    public static List<String> recognitionAll(String input) {
//        String path = input.substring(input.indexOf("=") + 1);
        long start=System.currentTimeMillis();
        try {
            int[] rgb;
            BufferedImage bi= ImageIO.read(new URL(input));
//            BufferedImage bi = Thumbnails.of(new URL(input)).size(1920, 1920).asBufferedImage();
            Map<String, Integer> colorCount = new HashMap<>();
            // 统计图中颜色标准的数量分布情况
            for (int w = 0; w < bi.getWidth(); w = w + 1) {
                for (int h = 0; h < bi.getHeight(); h = h + 1) {
                    // 取出每一个像素点的rgb值
//                    rgb = changeToRgb(bi.getRGB(w, h));
                    // 将rbg转换为符合颜色标准的十六进制形式
//                    String hexColor = changeRgb(rgb[0], rgb[1], rgb[2]);
                    // 统计下每一个颜色对应的像素数量
                    Integer count = colorCount.get(bi.getRGB(w, h)+"");
//                    Integer count = colorCount.get(hexColor);
                    if (count == null) {
                        count = 0;
                    }
                    count++;
                    colorCount.put(bi.getRGB(w, h)+"", count);
//                    colorCount.put(hexColor, count);
                }
            }
            Map<Integer, String> colorCountRev = new HashMap<>();
            List<Integer> countList = new ArrayList<>();
            for (String key : colorCount.keySet()) {
                colorCountRev.put(colorCount.get(key), key);
                countList.add(colorCount.get(key));
            }
            // 排序
            Collections.sort(countList);
            int length = countList.size();
            if (length > 4) {
                length = 4;
            }

            // 取出数量最多的前四种颜色
            String colors = "";
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= length; i++) {
                colors = String.valueOf(colorCountRev.get(countList.get(countList.size() - i)));
                list.add(colors);
            }
            long end=System.currentTimeMillis();
            System.out.println(end-start);
            return list;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> recognition(String input) {
//        String path = input.substring(input.indexOf("=") + 1);
        long start=System.currentTimeMillis();
        try {
            int[] rgb;
            BufferedImage origin= ImageIO.read(new URL(input));
            long end1=System.currentTimeMillis();
            System.out.println("end1:"+(end1-start));
            BufferedImage bi =
                    Thumbnails.of(new URL(input)).size(origin.getWidth()/10,
                            origin.getHeight()/10).asBufferedImage();
            System.out.println(origin.getWidth()/10);
            System.out.println(origin.getHeight()/10);
            Map<String, Integer> colorCount = new HashMap<>();
            // 统计图中颜色标准的数量分布情况
            for (int w = 0; w < bi.getWidth(); w = w + 1) {
                for (int h = 0; h < bi.getHeight(); h = h + 1) {
                    // 取出每一个像素点的rgb值
//                    rgb = changeToRgb(bi.getRGB(w, h));
                    // 将rbg转换为符合颜色标准的十六进制形式
//                    String hexColor = changeRgb(rgb[0], rgb[1], rgb[2]);
                    // 统计下每一个颜色对应的像素数量
                    Integer count = colorCount.get(bi.getRGB(w, h)+"");
//                    Integer count = colorCount.get(hexColor);
                    if (count == null) {
                        count = 0;
                    }
                    count++;
                    colorCount.put(bi.getRGB(w, h)+"", count);
//                    colorCount.put(hexColor, count);
                }
            }
            Map<Integer, String> colorCountRev = new HashMap<>();
            List<Integer> countList = new ArrayList<>();
            for (String key : colorCount.keySet()) {
                colorCountRev.put(colorCount.get(key), key);
                countList.add(colorCount.get(key));
            }
            // 排序
            Collections.sort(countList);
            int length = countList.size();
            if (length > 4) {
                length = 4;
            }

            // 取出数量最多的前四种颜色
            String colors = "";
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= length; i++) {
                colors = String.valueOf(colorCountRev.get(countList.get(countList.size() - i)));
                list.add(colors);
            }
            long end2=System.currentTimeMillis();
            System.out.println("end2:"+(end2-start));
            return list;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getMajorColor(String input) {
        try {
            final BufferedImage bi= ImageIO.read(new URL(input));
//            final int width=originImage.getWidth()/10;
//            final int height=originImage.getHeight()/10;
//            final BufferedImage bi = Thumbnails.of(originImage).size(width, height).asBufferedImage();
            final Map<String, Integer> colorCount = new HashMap<>(bi.getWidth() * bi.getHeight());
            int[] rgb;
            String hexColor;
            // 统计图中颜色标准的数量分布情况
            for (int w = bi.getMinX(); w < bi.getWidth(); w++) {
                for (int h = bi.getMinY(); h < bi.getHeight(); h++) {
                    // 取出每一个像素点的rgb值
                    rgb = changeToRgb(bi.getRGB(w, h));
                    // 将rbg转换为符合颜色标准的十六进制形式
                    hexColor = changeRgb(rgb[0], rgb[1], rgb[2]);
                    Integer count = colorCount.get(hexColor);
                    if (count == null) {
                        count = 0;
                    }
                    count++;
                    colorCount.put(hexColor, count);
                }
            }
            final Map<Integer, String> colorCountReverseKeyAndValue =
                    new HashMap<>(colorCount.size());
            final List<Integer> countList = new ArrayList<>(colorCount.size());
            for (final String key : colorCount.keySet()) {
                colorCountReverseKeyAndValue.put(colorCount.get(key), key);
                countList.add(colorCount.get(key));
            }
            // 排序
            countList.sort(Comparator.reverseOrder());
            // 取出数量最多的前四种颜色
            final int length=Math.min(countList.size(),colorAmount);
            final List<String> result = new ArrayList<>(length);
            String colors;
            for (int i = 0; i < length; i++) {
                colors = colorCountReverseKeyAndValue.get(countList.get(i));
                result.add(colors);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
//        while(true){
//        System.out.println(recognitionAll("https://qhrenderpicoss.kujiale.com/r/2020/07/03/L3D336S71ENDIPQ76VAUI5L6CLUF3P3UI888_8000x6000.jpg"));
//            for (final String s : recognition("https://qh-photostudio-oss.kujiale.com/prod/202007/L3D336S71ENDIPQ76VAUI5L6CLUF3P3UI888_8000x6000_8K.tif")) {
//                for (int i : changeToRgb(Integer.valueOf(s))) {
//                    System.out.print(i+" ");
//                }
//                System.out.println();
//            }
//        }

//        System.out.println(hexToTen("B6"));
//        for (int temp : changeToRgb(-4739677)) {
//            System.out.println(temp);
//        }
//        System.out.println(tenToHex(204));
//        for (String s : getMajorColor("https://qhrenderpicoss.kujiale.com/r/2020/10/12/L3D121S21ENDIKODQPQUI5L7GLUF3P3WU888_1600x1200.jpg")) {
//            System.out.println(s);
//        }
//        System.out.println(tenToHex(245));
//        while (true){
//            System.out.println(getMajorColor("https://qhrenderpicoss.kujiale" +
//                    ".com/dev/2021/01/18/L3D327S21ENDPUNKJI5SGTN5MLUF3P3WQ888_1024x576.jpg"));
//        }
//        for (int i : changeToRgbArr("336633")) {
//            System.out.println(i);
//        }
//        System.out.println(tenToHex(1));
//        System.out.println(hexToTen("01"));
        System.out.println(changeRgb(changeToRgbArr("4c4d48")[0],changeToRgbArr("4c4d48")[1],
                changeToRgbArr("4c4d48")[2]));
    }
}
