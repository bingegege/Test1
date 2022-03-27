package HelloWord1;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2022/2/22
 */
public class Solution {
    public void rec(TreeNode root, Long id) {
        if (root.id.equals(id)) {
            root.subList.add(new TreeNode());
            return;
        }
        if (CollectionUtils.isEmpty(root.subList)) {
            return;
        }
        for (TreeNode treeNode : root.subList) {
            rec(treeNode, id);
        }
    }

    public boolean rec1(TreeNode root, Long id) {
        if (root.id.equals(id)) {
            root.subList.add(new TreeNode());
            return true;
        }
        if (CollectionUtils.isEmpty(root.subList)) {
            return false;
        }
        for (TreeNode treeNode : root.subList) {
            if (rec1(treeNode, id)) {
                return true;
            }
        }
        return false;
    }
}

class TreeNode {
    Long id;
    List<TreeNode> subList;
}