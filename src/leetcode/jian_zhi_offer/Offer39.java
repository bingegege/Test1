package leetcode.jian_zhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zhenghuan
 * @date 2022/2/28
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        final Map<Integer, Integer> numKey = new HashMap<>(nums.length);
        int result = nums[0];
        for (int num : nums) {
            if (numKey.get(num) == null) {
                numKey.put(num, 1);
            } else {
                numKey.put(num, numKey.get(num) + 1);
            }
            if (numKey.get(result) < numKey.get(num)) {
                result = num;
            }
        }
        return result;
    }
}
