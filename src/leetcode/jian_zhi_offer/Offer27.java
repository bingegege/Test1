//package leetcode.jian_zhi_offer;
//
///**
// *
// * @author zhenghuan
// * @date 2022/2/17
// */
//public class Offer27 {
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) {
//            return root;
//        }
//        TreeNode leftTemp = root.left;
//        root.left = mirrorTree(root.right);
//        root.right = mirrorTree(leftTemp);
//        return root;
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
