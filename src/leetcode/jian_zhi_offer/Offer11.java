package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/2/20
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return numbers[0];
        }
        int left = 0, right = 1;
        while (right <= numbers.length - 1 && numbers[left] <= numbers[right]) {
            left++;
            right++;
        }
        if (right > numbers.length - 1) {
            return numbers[0];
        }
        return numbers[right];
    }
}
