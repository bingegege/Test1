package leetcode.jian_zhi_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2022/2/13
 */
public class Offer57_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(findContinuousSequence(9)));
    }
    public static int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return null;
        }
        int left=1;
        int right=2;
        int sum=left+right;
        List<int[]> res=new ArrayList<>();
        while(left<=target/2){
            if(sum<target){
                right++;
                sum+=right;
            }else if(sum>target){
                sum-=left;
                left++;
            }else {
                int[] temp=new int[right-left+1];
                for (int i = left; i <=right ; i++) {
                    temp[i-left]=i;
                }
                res.add(temp);
                sum-=left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
