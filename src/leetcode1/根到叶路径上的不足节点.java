package leetcode1;

import until.TreeNode;

/**
 * @Author: Ljx
 * @Date: 2023/5/22 11:24
 * @role:
 */
public class 根到叶路径上的不足节点 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        dfs(root, limit);
        return root;
    }

    public int dfs(TreeNode root, int limit) {
        int left = Integer.MAX_VALUE;
        if (root.left != null) {
            left = dfs(root.left, limit);
            if (left < limit) {
                root.left = null;
            }
        }
        int right = Integer.MAX_VALUE;
        if (root.right != null) {
            right = dfs(root.right, limit);
            if (right < limit) {
                root.right = null;
            }
        }
        int max;
        if (left != Integer.MAX_VALUE && right != Integer.MAX_VALUE) {
            max = Math.max(left + root.val, right + root.val);
        } else if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            max = root.val;
        } else if (left == Integer.MAX_VALUE) {
            max = right + root.val;
        } else {
            max = left + root.val;
        }
        return max;
    }
}
