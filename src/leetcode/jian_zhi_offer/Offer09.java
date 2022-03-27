package leetcode.jian_zhi_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author zhenghuan
 * @date 2022/2/12
 */
public class Offer09 {

}

class CQueue {

    Stack<Integer> before;
    Stack<Integer> after;

    public CQueue() {
        before = new Stack<>();
        after = new Stack<>();
    }

    public void appendTail(int value) {
        before.push(value);
    }

    public int deleteHead() {
        if (before.isEmpty()) {
            return -1;
        }
        while (!before.isEmpty()) {
            after.push(before.pop());
        }
        int res = after.pop();
        while (!after.isEmpty()) {
            before.push(after.pop());
        }
        return res;
    }
}
