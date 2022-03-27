package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/3/20
 */
public class Offer22 {
    //    public ListNode getKthFromEnd(ListNode head, int k) {
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//        ListNode res = null;
//        for (int i = 0; i < k; i++) {
//            res = stack.pop();
//        }
//        return res;
//    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head, right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
