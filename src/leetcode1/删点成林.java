package leetcode1;

import until.TreeUntil;
import until.TreeNode;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2023/5/30 8:05
 * @role:
 */
public class 删点成林 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        List<TreeNode> list = new ArrayList<>();
        addList(root, list, set,true);
        return list;
    }

    public TreeNode addList(TreeNode root, List<TreeNode> list, Set<Integer> set, boolean b) {
        if (root == null) {
            return null;
        }

        boolean contains = set.contains(root.val);
        root.left = addList(root.left, list, set, contains);
        root.right = addList(root.right, list, set, contains);
        if (contains) {
            return null;
        }else {
            if (b) {
                list.add(root);
            }
            return root;
        }


    }



    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        TreeNode root = TreeUntil.creatTree(arr);
        删点成林 s = new 删点成林();
        s.delNodes(root,new int[]{3,5});
    }
}
