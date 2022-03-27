package leetcode.jian_zhi_offer;

import java.util.Arrays;

/**
 *
 * @author zhenghuan
 * @date 2022/3/6
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = res[i];
        }
        return res;
    }
}
