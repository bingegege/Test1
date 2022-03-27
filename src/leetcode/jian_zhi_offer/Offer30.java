package leetcode.jian_zhi_offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author zhenghuan
 * @date 2022/2/12
 */
public class Offer30 {
}


class MinStack {

    Stack<Integer> before;
    Stack<Integer> after;

    /** initialize your data structure here. */
    public MinStack() {
        before = new Stack<>();
        after = new Stack<>();
    }

    public void push(int x) {
        before.push(x);
        if (after.isEmpty()) {
            after.push(x);
        } else {
            if (after.peek() >= x) {
                after.push(x);
            }
        }
    }

    public void pop() {
        if (before.isEmpty()) {
            return;
        }
        final Integer pop = before.pop();
        if (pop.equals(after.peek())) {
            after.pop();
        }
    }

    public int top() {
        return before.peek();
    }

    public int min() {
        if (after.isEmpty()) {
            return -1;
        }
        return after.peek();
    }
}