package 暴力递归;

import java.util.Stack;

/**
 * @Author: Ljx
 * @Date: 2023/4/18 10:06
 * @role:
 */
public class Code05_ReverseStackUsingRecursive {

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()){
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    private int f(Stack<Integer> stack) {

        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
}
