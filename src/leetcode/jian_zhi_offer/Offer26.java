//package leetcode.jian_zhi_offer;
//
//
///**
// *
// * @author zhenghuan
// * @date 2022/2/17
// */
//public class Offer26 {
//
//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if (A == null || B == null) {
//            return false;
//        }
//        return preOrder(A, B);
//    }
//
//    //前序遍历A树
//    public boolean preOrder(TreeNode A, TreeNode B) {
//        if (A == null) {
//            return false;
//        }
//        //递归判断A树的子树与B树是否相等，匹配到则返回
//        return recusive(A, B) || preOrder(A.left, B) || preOrder(A.right, B);
//    }
//
//    //递归判断A子树和B树的每个节点是否相等
//    public boolean recusive(TreeNode A, TreeNode B) {
//        if (A == null && B == null) {
//            return true;
//        } else if (A == null) {
//            return false;
//        } else if (B == null) {
//            return true;
//        } else if (A.val == B.val) {
//            return recusive(A.left, B.left) && recusive(A.right, B.right);
//        } else {
//            return false;
//        }
//    }
//}
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
