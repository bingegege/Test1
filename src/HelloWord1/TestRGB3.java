package HelloWord1;

import HelloWord1.Enum.ColorBeforeEnum;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhenghuan
 * @date 2021/5/17
 */
public class TestRGB3 {

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

    public static List<String> getMajorColor(final String input){
        try {
            final BufferedImage originImage = ImageIO.read(new URL(input));
            final int width = originImage.getWidth() / 10;
            final int height = originImage.getHeight() / 10;
            final BufferedImage bi = Thumbnails.of(originImage).size(width, height)
                    .asBufferedImage();
            final Map<String, Integer> colorCount = new HashMap<>(bi.getWidth() * bi.getHeight());
            int[] rgbArr;
            String hexColor;
            Integer count;
            // 统计图中颜色标准的数量分布情况
            for (int w = bi.getMinX(); w < bi.getWidth(); w++) {
                for (int h = bi.getMinY(); h < bi.getHeight(); h++) {
                    // 取出每一个像素点的rgb值
                    rgbArr = changeToRgb(bi.getRGB(w, h));
                    hexColor = changeToHex(rgbArr);
                    count = colorCount.get(hexColor);
                    if (count == null) {
                        count = 0;
                    }
                    count++;
                    colorCount.put(hexColor, count);
                }
            }
            return sortAndGetFourMajorColour(colorCount);
        } catch (final IOException e) {
            return null;
        }
    }

    // 取出数量最多的前四种颜色
    public static List<String> sortAndGetFourMajorColour(final Map<String, Integer> colorCount) {
        if (colorCount == null || colorCount.isEmpty()) {
            return Collections.emptyList();
        }
        final List<Integer> countList = new ArrayList<>(colorCount.size());
        for (final String key : colorCount.keySet()) {
            countList.add(colorCount.get(key));
        }
        // 排序
        countList.sort(Comparator.reverseOrder());
        // 取出数量最多的前四种颜色
        final int length = Math.min(countList.size(), colorAmount);
        final List<String> result = new ArrayList<>(length);
        final HashSet<Byte> excludeSimilarColour = new HashSet<>(length);
        final HashSet<Integer> excludeSameCount = new HashSet<>(countList.size());
        Byte code;
        List<String> hexValueList;
        for (final Integer count : countList) {
            if (excludeSameCount.add(count)) {
                hexValueList = getKeyList(colorCount, count);
                for (final String hexValue : hexValueList) {
                    code = ColorBeforeEnum.getCodeByHexValue(changeRgb(changeToRgbArr(hexValue)));
                    if (excludeSimilarColour.add(code)) {
                        result.add(hexValue);
                    }
                    if (result.size() == length) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static <K, V> List<K> getKeyList(final Map<K, V> map, final V value) {
        if (map == null || map.isEmpty()) {
            return Collections.emptyList();
        }
        final List<K> keyList = new ArrayList<>();
        for (final K key : map.keySet()) {
            if (map.get(key).equals(value)) {
                keyList.add(key);
            }
        }
        return keyList;
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

    public static void main(String[] args) {

        List<String> res=getMajorColor("https://qhyxpicoss.kujiale" +
                ".com/dev/2019/11/08/L3D121S21ENDIDNPWYFSGRONILUF3P3WQ888_1600x1200.jpg");
        for (String re : res) {
            System.out.println(re);
        }
    }
}
