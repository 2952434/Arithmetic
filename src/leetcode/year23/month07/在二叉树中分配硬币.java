package leetcode.year23.month07;

public class 在二叉树中分配硬币 {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int move;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }

    private int dfs(TreeNode root) {
        int moveLeft = 0;
        int moveRight = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            moveLeft = dfs(root.left);
        }
        if (root.right != null) {
            moveRight = dfs(root.right);
        }
        move += Math.abs(moveLeft) + Math.abs(moveRight);
        return root.val + moveLeft + moveLeft - 1;
    }
}
