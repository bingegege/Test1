package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/3/20
 */
public class OfferII21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        for (int i = 0; i < n + 1; i++) {
            right = right.next;
            if (right == null) {
                return right;
            }
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    111
}
