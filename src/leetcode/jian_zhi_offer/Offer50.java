package leetcode.jian_zhi_offer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author zhenghuan
 * @date 2022/3/13
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        if (s.isEmpty()) {
            return ' ';
        }
        int left = 0;
        Set<Character> filter = new HashSet<>();
        char res = ' ';
        while (left <= s.length() - 1) {
            char temp = s.charAt(left);
            boolean flag = true;
            if (filter.add(temp)) {
                for (int i = left + 1; i < s.length(); i++) {
                    if (s.charAt(i) == temp) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res = temp;
                    break;
                }
            }
            left++;
        }
        return res;
    }
//
//    public static void main(String[] args) {
//        System.out.println(firstUniqChar("cc") + "--");
//        System.out.println(111);
//    }
}
