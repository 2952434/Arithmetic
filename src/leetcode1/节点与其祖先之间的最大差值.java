package leetcode1;

import until.TreeNode;

public class 节点与其祖先之间的最大差值 {
    public static int maxAncestorDiff(TreeNode root) {
        process(root);
        return max;
    }
    static  int max = Integer.MIN_VALUE;
    public static int[] process(TreeNode root){
        if (root.left == null && root.right == null) {
            return new int[]{root.val,root.val};
        }
        int[] arr = new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        if (root.left != null) {
            int[] process = process(root.left);
            max = Math.max(max,Math.max(Math.abs(root.val - process[0]),Math.abs(root.val - process[1])));
            arr[0] = Math.min(process[0],root.val);
            arr[1] = Math.max(process[1],root.val);
        }
        if (root.right != null) {
            int[] process = process(root.right);
            max =Math.max(max,Math.max(Math.abs(root.val - process[0]),Math.abs(root.val - process[1])));
            arr[0] = Math.min(arr[0],Math.min(process[0],root.val));
            arr[1] = Math.max(arr[1],Math.max(process[1],root.val));
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        node.right = node1;
        node1.right = node2;
        node2.left = node3;
        System.out.println(maxAncestorDiff(node));
    }
}