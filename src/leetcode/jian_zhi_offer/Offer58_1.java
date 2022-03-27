package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/3/11
 */
public class Offer58_1 {
    public static String reverseWords(String s) {
        final String[] s1 = s.trim().split(" ");
        String res = "";
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("")) {
                res += s1[i];
                res += " ";
            }
        }
        return res.trim();
    }

    public static void main(String[] args) {
        reverseWords("a good   example");
    }
}
