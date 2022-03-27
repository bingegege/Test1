package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/2/26
 */
public class Offer10 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0, second = 1;
        while (n > 1) {
            int temp = (first + second)%1000000007;
            first = second;
            second = temp;
            n--;
        }
        return second;
    }

    public static void main(String[] args) {
        char a='斌';
        System.out.println((int)a);
    }
}
