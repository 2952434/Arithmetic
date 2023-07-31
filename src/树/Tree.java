package 树;

import java.util.Stack;

/**
 * @Author: Ljx
 * @Date: 2023/4/14 8:38
 * @role:
 */
public class Tree {

//    先序遍历非递归
    public static void preOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                System.out.println(pop);
//                先压右
                if (pop.right!=null){
                    stack.add(pop.right);
                }
//                再压左
                if (pop.left!=null){
                    stack.add(pop.left);
                }
            }
        }
    }

//    后续遍历 左右头
    public static void posOrderUnRecur(Node head) {
        if (head!=null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop());
            }
        }
    }

//    中序遍历  左中右
    public static void inOrderUnRecur(Node head){
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head !=null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head);
                    head = head.right;
                }
            }
        }
    }


//    判断一棵树是否是平衡二叉树
    public static ReturnType process(Node x){
        if (x == null){
            return new ReturnType(true,0);
        }

        ReturnType leftDate = process(x.left);
        ReturnType rightDate = process(x.right);
        int height = Math.max(leftDate.height,rightDate.height) + 1;

        boolean isBalanced = leftDate.isBalanced && rightDate.isBalanced
                && Math.abs(leftDate.height - rightDate.height) < 2;
        return new ReturnType(isBalanced,height);

    }

}
