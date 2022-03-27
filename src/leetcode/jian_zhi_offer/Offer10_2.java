package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/2/27
 */
public class Offer10_2 {

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int first = 1, second = 1;
        while (n > 1) {
            int temp = (first + second) % 1000000007;
            first = second;
            second = temp;
            n--;
        }
        return second;
    }
}
