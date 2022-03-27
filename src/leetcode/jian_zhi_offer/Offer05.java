package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/3/3
 */
public class Offer05 {
    public String replaceSpace(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        byte a='a';
        System.out.println(a);
    }
}
