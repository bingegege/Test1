package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/2/14
 */
public class Offer18 {

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                return head;
            }
            cur = cur.next;
        }
        return head;
    }
}