package leetcode.jian_zhi_offer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author zhenghuan
 * @date 2022/2/10
 */
public class Offer03 {
//    public static void main(String[] args) {
//        findRepeatNumber1(new int[]{2,2,4,1,3});
//    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> filterSet=new HashSet<>(nums.length);
        for (int num : nums) {
            if(!filterSet.add(num)){
                return num;
            }
        }
        return -1;
    }

    public static int findRepeatNumber1(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
