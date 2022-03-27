//package leetcode.jian_zhi_offer;
//
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
///**
// *
// * @author zhenghuan
// * @date 2022/2/15
// */
//public class Offer07 {
//    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
//    //左右子树，递归
//    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
//    int[] preorder;//保留的先序遍历
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        this.preorder = preorder;
//        for (int i = 0; i < preorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return recursive(0, 0, inorder.length - 1);
//    }
//
//    /**
//     * @param pre_root_idx  先序遍历的索引
//     * @param in_left_idx  中序遍历的索引
//     * @param in_right_idx 中序遍历的索引
//     */
//    public TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
//        //相等就是自己
//        if (in_left_idx > in_right_idx) {
//            return null;
//        }
//        //root_idx是在先序里面的
//        TreeNode root = new TreeNode(preorder[pre_root_idx]);
//        // 有了先序的,再根据先序的，在中序中获 当前根的索引
//        int idx = map.get(preorder[pre_root_idx]);
//
//        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
//        root.left = recursive(pre_root_idx + 1, in_left_idx, idx - 1);
//
//        //由根节点在中序遍历的idx 区分成2段,idx 就是根
//
//        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
//        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
//        root.right = recursive(pre_root_idx + (idx - 1 - in_left_idx + 1) + 1, idx + 1,
//                in_right_idx);
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
//
//class Main {
//    public static void main(String[] args) {
////        Offer07 o = new Offer07();
////        o.buildTree(new int[]{ 3, 9, 20, 15, 7 }, new int[]{ 9, 3, 15, 20, 7 });
//        Integer[] arr = new Integer[]{ 1, 2, 3, 4, 5 };
//        final List<Integer> list = Arrays.asList(Arrays.copyOfRange(arr, 0, 2));
//        System.out.println(list);
//    }
//}
//
//class Solution1 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        if (n == 0) {
//            return null;
//        }
//        int rootVal = preorder[0], rootIndex = 0;
//        for (int i = 0; i < n; i++) {
//            if (inorder[i] == rootVal) {
//                rootIndex = i;
//                break;
//            }
//        }
//        TreeNode root = new TreeNode(rootVal);
//        root.left = buildTree(
//                Arrays.copyOfRange(preorder, 1, 1 + rootIndex),
//                Arrays.copyOfRange(inorder, 0, rootIndex));
//        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n),
//                Arrays.copyOfRange(inorder, rootIndex + 1, n));
//
//        return root;
//    }
//}
//
//class Solution2 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0) {
//            return null;
//        }
//        int rootVal = preorder[0];
//        int rootIndex = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == rootVal) {
//                rootIndex = i;
//            }
//        }
//        TreeNode root = new TreeNode(rootVal);
//        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex),
//                Arrays.copyOfRange(inorder, 0, rootIndex));
//        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length),
//                Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
//        return root;
//    }
//}
//
