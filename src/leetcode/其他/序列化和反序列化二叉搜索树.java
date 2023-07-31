package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/5/11 17:09
 * @role: https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */


class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll==null){
                list.add(null);
            }else {
                list.add(poll.val);
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return list.toString().substring(1,list.toString().length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(", ");
        if ("null".equals(split[0])){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < split.length; i+=2) {
            while (!queue.isEmpty()){
               TreeNode poll = queue.poll();
               TreeNode left = null;
               TreeNode right = null;
               if (!"null".equals(split[i])){
                   left = new TreeNode(Integer.parseInt(split[i++]));
                   queue.add(left);
               }else {
                   i++;
               }
               if (!"null".equals(split[i])){
                   right = new TreeNode(Integer.parseInt(split[i++]));
                   queue.add(right);
               }else {
                   i++;
               }
               poll.left = left;
               poll.right = right;
            }

        }
        return root;
    }
}
public class 序列化和反序列化二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        System.out.println(codec.deserialize(codec.serialize(root)));
    }
}
