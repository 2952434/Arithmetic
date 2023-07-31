package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/5/1 22:18
 * @role: https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */


class TreeNode1 {
     int val;
     TreeNode1 left;
     TreeNode1 right;
     TreeNode1() {}
     TreeNode1(int val) { this.val = val; }
     TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

//class Solution {
//    List<Integer> list = new ArrayList();
//    public List<Integer> getAllElements(TreeNode1 root1, TreeNode1 root2) {
//        dfs(root1);
//        dfs(root2);
//        Collections.sort(list);
//        return list;
//    }
//
//    public void dfs(TreeNode1 root){
//        if (root==null){
//            return;
//        }
//        list.add(root.val);
//        dfs(root.left);
//        dfs(root.right);
//    }
//}
public class 两棵二叉搜索树中的所有元素 {
    public static void main(String[] args) {

    }
}
