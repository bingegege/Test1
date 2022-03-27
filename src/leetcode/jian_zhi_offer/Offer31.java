package leetcode.jian_zhi_offer;

import java.util.Stack;

/**
 *
 * @author zhenghuan
 * @date 2022/3/5
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        Stack<Integer> temp = new Stack<>();
        int j = 0;
        for (int num : pushed) {
            temp.push(num);
            while (!temp.empty() && temp.peek() == popped[j]) {
                temp.pop();
                j++;
            }
        }
        return temp.empty();
    }
}
