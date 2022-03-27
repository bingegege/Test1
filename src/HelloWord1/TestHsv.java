package HelloWord1;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;

/**
 *
 * @author zhenghuan
 * @date 2021/4/28
 */
public class TestHsv {

    // 计算绿色像素所占比例，传入参数为图片的文件路径
    public static String calculateGreen(String image) throws Exception {

        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new URL(image));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //长宽
        int width = bi.getWidth();
        int height = bi.getHeight();

        //横纵坐标起始点
        int minx = bi.getMinX();
        int miny = bi.getMinY();

        //绿色像素点个数
        long greenNumber = 0;


        int[] rgb = new int[3];// 定义RGB空间
        float[] hsv = new float[3];// 定义HSV空间

        // 开始遍历所有像素点
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {

                // 当前像素点
                int pixel = bi.getRGB(i, j);

                // 获取RGB各值
                rgb[0] = (pixel & 0xff0000) >> 16;//R
                rgb[1] = (pixel & 0xff00) >> 8;//G
                rgb[2] = (pixel & 0xff);//B

                // rgb转hsv
                Color.RGBtoHSB(rgb[0], rgb[1], rgb[2], hsv);

                //使用hsv判断该像素点是否可以判定为绿色像素点
                if (hsv[2] >= 0.075 && hsv[1] >= 0.15 && hsv[0] > 0.1389 &&
                        hsv[0] <= 0.4444) {
                    greenNumber++;
                }
            }
        }

        // 总像素点个数
        long totalPixelNumber = width * height;

        // 获取浮点数表示的占比
        double greenPixelProportion = (double) greenNumber / totalPixelNumber;

        // 返回百分制字符串
        return translateDoubleIntoPercent(greenPixelProportion);
    }

    /**
     * 将浮点数转换为百分制
     * @param d
     * @return
     */
    public static String translateDoubleIntoPercent(double d) {
        BigDecimal bDecimal = new BigDecimal(d);
        bDecimal = bDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
        DecimalFormat dFormat = new DecimalFormat("0.00%");
        String result = dFormat.format(bDecimal.doubleValue());
        return result;
    }
}

