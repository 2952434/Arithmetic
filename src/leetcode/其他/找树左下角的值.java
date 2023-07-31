package leetcode.其他;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Ljx
 * @Date: 2022/6/22 22:01
 * @role:
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class 找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            stack.add(poll.val);
            if (poll.right!=null){
                queue.add(poll.right);
            }
            if (poll.left!=null){
                queue.add(poll.left);
            }
        }
        return stack.peek();
    }
}
