package leetcode1;

import until.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Ljx
 * @Date: 2023/4/21 10:59
 * @role:
 */
public class 反转二叉树的奇数层 {
    public static TreeNode reverseOddLevels(TreeNode root) {

//        return test01(root);

        dfs(root.left, root.right, 1);
        return root;
    }

    public static TreeNode test01(TreeNode root){
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        queue1.add(root);
        int x = 0;
        while (!queue1.isEmpty()){
            Queue<TreeNode> queue2 = new ArrayDeque<>();
            if (x % 2 == 0){
                while (!queue1.isEmpty()) {
                    TreeNode poll = queue1.poll();
                    queue2.add(poll);
                    stack.add(poll.val);
                }
                queue1.addAll(queue2);
                queue2.clear();
                while (!queue1.isEmpty()) {
                    TreeNode poll = queue1.poll();
                    poll.val = stack.pop();
                    if (poll.left!=null){
                        queue2.add(poll.left);
                    }
                    if (poll.right!=null) {
                        queue2.add(poll.right);
                    }
                }
            } else {
                while (!queue1.isEmpty()){
                    TreeNode poll = queue1.poll();
                    if (poll.left!=null){
                        queue2.add(poll.left);
                    }
                    if (poll.right!=null) {
                        queue2.add(poll.right);
                    }
                }

            }
            queue1 = queue2;
            x++;
        }
        return root;
    }


    public static void dfs(TreeNode l, TreeNode r, int level) {
        if (l == null) {
            return;
        }
        if (level % 2 != 0) {
            int val = r.val;
            r.val = l.val;
            l.val = val;
        }
        dfs(l.left, r.right, level + 1);
        dfs(l.right, r.left, level + 1);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,8,13,21,34};
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 0; i < arr.length-2; i+=2) {
            TreeNode poll = queue.poll();
            poll.left = new TreeNode(arr[i+1]);
            queue.add(poll.left);
            poll.right = new TreeNode(arr[i+2]);
            queue.add(poll.right);
        }
        reverseOddLevels(root);
    }
}
