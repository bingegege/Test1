//package leetcode.jian_zhi_offer;
//
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// *
// * @author zhenghuan
// * @date 2022/2/14
// */
//public class Offer06 {
//
//}
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
//
//class Solution1 {
//    public int[] reversePrint(ListNode head) {
//        if (head == null) {
//            return new int[0];
//        }
//        List<Integer> resList = new ArrayList<>();
//        ListNode temp = head;
//        while (temp != null) {
//            resList.add(temp.val);
//            temp = temp.next;
//        }
//        Collections.reverse(resList);
//        int[] res = new int[resList.size()];
//        for (int i = 0; i < resList.size(); i++) {
//            res[i] = resList.get(i);
//        }
//        return res;
//    }
//}
//
//class Solution {
//    public int[] reversePrint(ListNode head) {
//        if (head == null) {
//            return new int[0];
//        }
//        List<Integer> list=recursion(head);
//        int[] res=new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i]=list.get(i);
//        }
//        return res;
//    }
//
//    public List<Integer> recursion(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        if (head.next == null) {
//            list.add(head.val);
//            return list;
//        }
//        list.addAll(recursion(head.next));
//        list.add(head.val);
//        return list;
//    }
//
//}
//
