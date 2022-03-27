package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/2/20
 */
public class Offer14 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        return rec(n);
    }

    public int rec(int n) {
        if (n <= 4) {
            return n;
        }
        return rec(n - 3) * rec(3);
    }
}
