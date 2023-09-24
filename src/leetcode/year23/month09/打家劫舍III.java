package leetcode.year23.month09;

import until.TreeNode;

/**
 * @Author: Ljx
 * @Date: 2023/9/18 23:04
 * @role:
 */
public class 打家劫舍III {

    public int rob(TreeNode root) {
        RobBean dfs = dfs(root);
        return Math.max(dfs.noRob, dfs.rob);
    }

    public RobBean dfs(TreeNode root) {
        if (root == null) {
            return new RobBean(0, 0);
        }
        RobBean dfsLeft = dfs(root.left);
        RobBean dfsRight = dfs(root.right);
        int rob = root.val + dfsLeft.noRob + dfsRight.noRob;
        int noRob = Math.max(dfsLeft.rob, dfsLeft.noRob) + Math.max(dfsRight.rob, dfsRight.noRob);
        return new RobBean(rob, noRob);

    }

    class RobBean {
        public int rob;

        public int noRob;

        public RobBean(int rob, int noRob) {
            this.rob = rob;
            this.noRob = noRob;
        }
    }
}
