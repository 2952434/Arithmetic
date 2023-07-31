package leetcode.其他;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Ljx
 * @Date: 2022/5/16 8:16
 * @role:
 */




class Solution2 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null){
            while (curr != null){
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            if (prev == p){
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }

}

public class 面试题0406后继者 {
    public static void main(String[] args) {

    }

}
