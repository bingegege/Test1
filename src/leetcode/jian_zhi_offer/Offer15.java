package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/3/2
 */
public class Offer15 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
