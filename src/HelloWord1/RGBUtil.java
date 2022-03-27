package HelloWord1;

import HelloWord1.Enum.ColorEnum;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

/**
 *
 * @author zhenghuan
 * @date 2021/7/1
 */
public class RGBUtil {

    public static void main(String[] args) {
        Map<Byte, String> map = getMajorColor(
                "https://qhrenderpicoss.kujiale.com/r/2021/02/19/L3D204S21ENDPUYNCGNSGF6HALUF3P3XO888_1920x1920.jpg");
//);
        System.out.println(map);
//        System.out.println(Math.round(1.49));
    }

    private static final float weight = 0.1f;

    private static final int colorAmount = 4;

    // 颜色标准数（固定差值）
    private static final float colorNum = 51.0f;

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

    //降低色系权重，目前看来，黑色,白色,灰色,棕色这四种颜色的权重需要降低
    public static void reduceWeightOfColour(
            final Map<Byte, Integer> colourTagCountMapping) {
        if (colourTagCountMapping.get(ColorEnum.BLACK.getCode()) != null) {
            colourTagCountMapping.put(ColorEnum.BLACK.getCode(),
                    Math.round(weight * colourTagCountMapping.get(ColorEnum.BLACK.getCode())));
        }
        if (colourTagCountMapping.get(ColorEnum.WHITE.getCode()) != null) {
            colourTagCountMapping.put(ColorEnum.WHITE.getCode(),
                    Math.round(weight * colourTagCountMapping.get(ColorEnum.WHITE.getCode())));
        }
        if (colourTagCountMapping.get(ColorEnum.GRAY.getCode()) != null) {
            colourTagCountMapping.put(ColorEnum.GRAY.getCode(),
                    Math.round(weight * colourTagCountMapping.get(ColorEnum.GRAY.getCode())));
        }
        if (colourTagCountMapping.get(ColorEnum.BROWN.getCode()) != null) {
            colourTagCountMapping.put(ColorEnum.BROWN.getCode(),
                    Math.round(weight * colourTagCountMapping.get(ColorEnum.BROWN.getCode())));
        }
    }

    public static Map<Byte, String> getMajorColor(final String input) {
        try {
            final BufferedImage originImage = ImageIO.read(new URL(input));
            final int width = originImage.getWidth() / 10;
            final int height = originImage.getHeight() / 10;
            final BufferedImage bi = Thumbnails.of(originImage).size(width, height)
                    .asBufferedImage();
            final Map<Byte, Integer> colourTagCountMapping = new HashMap<>(
                    ColorEnum.values().length);
            final Map<Byte, Map<String, Integer>> colourTagHexColorMapping =
                    new HashMap<>(ColorEnum.values().length);
            int[] rgbArr;
            String hexColour;
            Integer countOfHexColour;
            Integer countOfColourTag;
            byte colourTag;
            // 统计图中颜色标准的数量分布情况
            for (int w = bi.getMinX(); w < bi.getWidth(); w++) {
                for (int h = bi.getMinY(); h < bi.getHeight(); h++) {
                    // 取出每一个像素点的rgb值
                    rgbArr = changeToRgb(bi.getRGB(w, h));
                    hexColour = changeToHex(rgbArr);
                    colourTag = getColourTag(rgbArr);
                    countOfColourTag = colourTagCountMapping.get(colourTag);
                    if (countOfColourTag == null) {
                        countOfColourTag = 0;
                    }
                    countOfColourTag++;
                    colourTagCountMapping.put(colourTag, countOfColourTag);
                    colourTagHexColorMapping.computeIfAbsent(colourTag, k -> Maps.newHashMap());
                    countOfHexColour = colourTagHexColorMapping.get(colourTag).get(hexColour);
                    if (countOfHexColour == null) {
                        countOfHexColour = 0;
                    }
                    countOfHexColour++;
                    colourTagHexColorMapping.get(colourTag).put(hexColour, countOfHexColour);
                }
            }
            return sortAndGetFourMajorColour(colourTagCountMapping, colourTagHexColorMapping);
        } catch (final IOException e) {
            return null;
        }
    }

    public static Map<Byte, String> getMajorColor1(final String input) {
        try {
            final BufferedImage originImage = ImageIO.read(new URL(input));
            final int width = originImage.getWidth() / 10;
            final int height = originImage.getHeight() / 10;
            final BufferedImage bi = Thumbnails.of(originImage).size(width, height)
                    .asBufferedImage();
            final Map<Byte, Integer> colourTagCountMapping = new HashMap<>(
                    ColorEnum.values().length);
            final Map<Byte, Map<String, Integer>> colourTagHexColorMapping =
                    new HashMap<>(ColorEnum.values().length);
            int[] rgbArr;
            float[] hsv = new float[3];
            String hexColour;
            Integer countOfHexColour;
            Integer countOfColourTag;
            byte colourTag;
            // 统计图中颜色标准的数量分布情况
            for (int w = bi.getMinX(); w < bi.getWidth(); w++) {
                for (int h = bi.getMinY(); h < bi.getHeight(); h++) {
                    // 取出每一个像素点的rgb值
                    rgbArr = changeToRgb(bi.getRGB(w, h));
//                    hsv= Color.RGBtoHSB(rgbArr[0], rgbArr[1], rgbArr[2], hsv);
                    hsv = rgbToHsv(rgbArr);
                    hexColour = changeToHex(rgbArr);
                    colourTag = getColourTag(rgbArr);
                    countOfColourTag = colourTagCountMapping.get(colourTag);
                    if (countOfColourTag == null) {
                        countOfColourTag = 0;
                    }
                    countOfColourTag++;
                    colourTagCountMapping.put(colourTag, countOfColourTag);
                    colourTagHexColorMapping.computeIfAbsent(colourTag, k -> Maps.newHashMap());
                    countOfHexColour = colourTagHexColorMapping.get(colourTag).get(hexColour);
                    if (countOfHexColour == null) {
                        countOfHexColour = 0;
                    }
                    countOfHexColour++;
                    colourTagHexColorMapping.get(colourTag).put(hexColour, countOfHexColour);
                }
            }
            return sortAndGetFourMajorColour(colourTagCountMapping, colourTagHexColorMapping);
        } catch (final IOException e) {
            return null;
        }
    }

    static float[] rgbToHsv(int[] rgb) {
        //切割rgb数组
        int R = rgb[0];
        int G = rgb[1];
        int B = rgb[2];
        //公式运算 /255
        float R_1 = R / 255f;
        float G_1 = G / 255f;
        float B_1 = B / 255f;
        //重新拼接运算用数组
        float[] all = { R_1, G_1, B_1 };
        float max = all[0];
        float min = all[0];
        //循环查找最大值和最小值
        for (int i = 0; i < all.length; i++) {
            if (max <= all[i]) {
                max = all[i];
            }
            if (min >= all[i]) {
                min = all[i];
            }
        }
        float C_max = max;
        float C_min = min;
        //计算差值
        float diff = C_max - C_min;
        float hue = 0f;
        //判断情况计算色调H
        if (diff == 0f) {
            hue = 0f;
        } else {
            if (C_max == R_1) {
                hue = (((G_1 - B_1) / diff) % 6) * 60f;
            }
            if (C_max == G_1) {
                hue = (((B_1 - R_1) / diff) + 2f) * 60f;
            }
            if (C_max == B_1) {
                hue = (((R_1 - G_1) / diff) + 4f) * 60f;
            }
        }
        //计算饱和度S
        float saturation;
        if (C_max == 0f) {
            saturation = 0f;
        } else {
            saturation = diff / C_max;
        }
        //计算明度V
        float value = C_max;
        float[] result = { hue, saturation, value };
        return result;
    }


    public static byte getColourTag(final int[] rgbArr) {
        if (rgbArr == null || rgbArr.length != 3) {
            throw new IllegalArgumentException("rgbArr is not expected");
        }
        return ColorEnum.getCodeByHexValue(changeRgb(rgbArr));
    }

    // 取出数量最多的前四种颜色
    public static Map<Byte, String> sortAndGetFourMajorColour(
            final Map<Byte, Integer> colourTagCountMapping,
            final Map<Byte, Map<String, Integer>> colourTagHexColorMapping) {
        if (MapUtils.isEmpty(colourTagCountMapping) || MapUtils.isEmpty(colourTagHexColorMapping)) {
            return Maps.newHashMap();
        }
        reduceWeightOfColour(colourTagCountMapping);
        final List<Map.Entry<Byte, Integer>> sortedColourTags = sortedByValue(
                colourTagCountMapping);
        // 取出数量最多的前四种颜色
        final int length = Math.min(sortedColourTags.size(), colorAmount);
        final Map<Byte, String> result = new LinkedHashMap<>(length);
        for (int i = 0; i < sortedColourTags.size(); i++) {
            final Map<String, Integer> HexColorCountMapping =
                    colourTagHexColorMapping.get(sortedColourTags.get(i).getKey());
            final List<Map.Entry<String, Integer>> colourTagHexColorEntries = sortedByValue(
                    HexColorCountMapping);
            result.put(sortedColourTags.get(i).getKey(), colourTagHexColorEntries.get(0).getKey());
            if (result.size() == length) {
                break;
            }
        }
        return result;
    }

    public static <K> List<Map.Entry<K, Integer>> sortedByValue(final Map<K, Integer> map) {
        if (MapUtils.isEmpty(map)) {
            return Collections.emptyList();
        }
        return map.entrySet().stream().sorted(
                (o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(
                Collectors.toList());
    }


    // 将BufferImage取出来的rgb值转换为rgb三通道
    public static int[] changeToRgb(final int pixel) {
        final int[] rgb = new int[3];
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);
        return rgb;
    }

    // 将十进制形式rgb转为符合标准颜色的十六进制字符串形式
    public static String changeRgb(final int[] arr) {
        // 通过颜色标准数计算颜色标准key
        final int redKey = Math.round(Float.parseFloat(arr[0] + "") / colorNum);
        final int greenKey = Math.round(Float.parseFloat(arr[1] + "") / colorNum);
        final int blueKey = Math.round(Float.parseFloat(arr[2] + "") / colorNum);
        // 通过颜色标准key取出标准颜色
        final String rs = colorStandard.get(redKey);
        final String gs = colorStandard.get(greenKey);
        final String bs = colorStandard.get(blueKey);
        return rs + gs + bs;
    }

    // 将十进制rgb数组转为十六进制字符串形式
    public static String changeToHex(final int[] arr) {
        if (arr == null || arr.length != 3) {
            return null;
        }
        return addZero(tenToHex(arr[0])) + addZero(tenToHex(arr[1])) + addZero(tenToHex(arr[2]));
    }

    public static String addZero(final String hexVal) {
        if (hexVal.length() == 1) {
            return "0" + hexVal;
        }
        return hexVal;
    }


    // 将十六进制字符串转为十进制rgb数组
    public static int[] changeToRgbArr(final String hexStr) {
        if (hexStr == null) {
            return null;
        }
        final int[] rgbArr = new int[3];
        rgbArr[0] = hexToTen(hexStr.substring(0, 2));
        rgbArr[1] = hexToTen(hexStr.substring(2, 4));
        rgbArr[2] = hexToTen(hexStr.substring(4));
        return rgbArr;
    }

    // 十进制转十六进制
    public static String tenToHex(final int x) {
        return Integer.toHexString(x);
    }

    // 十六进制转十进制
    public static Integer hexToTen(final String hex) {
        return Integer.parseInt(hex, 16);
    }
}
