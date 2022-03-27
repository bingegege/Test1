package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/2/13
 */
public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 1 || target <= 1) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
