package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/6/24 8:21
 * @role:
 */
public class 在每个树行中找最大值 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            list.add(max(queue, queue1));
            Integer max = max(queue1, queue);
            if (max!=null){
                list.add(max);
            }
        }
        return list;
    }
    public Integer max(Queue<TreeNode> queue,Queue<TreeNode> queue1){
        int max = Integer.MIN_VALUE;
        if (queue.isEmpty()){
            return null;
        }
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            max = Math.max(poll.val,max);
            if (poll.right!=null){
                queue1.add(poll.right);
            }
            if (poll.left!=null){
                queue1.add(poll.left);
            }
        }
        return max;
    }
}
