package leetcode.jian_zhi_offer;

import java.util.Arrays;

/**
 *
 * @author zhenghuan
 * @date 2022/2/25
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        final Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array, (t1, t2) -> {
            if (t1.equals(t2)) {
                return 0;
            }
            String str1 = String.valueOf(t1);
            String str2 = String.valueOf(t2);
            Long merge1 = Long.valueOf(str1 + str2);
            Long merge2 = Long.valueOf(str2 + str1);
            if (merge1 < merge2) {
                return -1;
            } else if (merge1 > merge2) {
                return 1;
            } else {
                return 0;
            }
        });
        String res = "";
        for (Integer integer : array) {
            res += integer;
        }
        return res;
    }

    public static void main(String[] args) {
        char a='1';
        System.out.println((byte)a);//49
        char b=106;
        System.out.println((byte)b);//106
        System.out.println(b);//j
    }
}
