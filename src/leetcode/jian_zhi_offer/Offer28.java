package leetcode.jian_zhi_offer;

/**
 *
 * @author zhenghuan
 * @date 2022/2/18
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recusive(root.left, root.right);
    }

    public boolean recusive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return recusive(left.left, right.right) && recusive(left.right, right.left);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
