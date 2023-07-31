package until;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: Ljx
 * @Date: 2023/5/30 9:04
 * @role:
 */
public class TreeUntil {

    public static TreeNode creatTree(int[] arr) {
        TreeNode root = new TreeNode();
        root.val = arr[0];
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 1; i < arr.length; i += 2) {
            TreeNode poll = queue.poll();
            poll.left = new TreeNode(arr[i]);
            poll.right = new TreeNode(arr[i+1]);
            queue.add(poll.left);
            queue.add(poll.right);
        }
        return root;
    }
}
