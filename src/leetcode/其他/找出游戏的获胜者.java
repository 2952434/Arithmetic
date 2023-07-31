package leetcode.其他;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Ljx
 * @Date: 2022/5/4 23:19
 * @role: https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
public class 找出游戏的获胜者 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }
    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int x = 0;
        while (!queue.isEmpty()){
            for (int i = 0; i < k; i++) {
                if (i==k-1){
                    if (queue.isEmpty()){
                        return x;
                    }
                    x = queue.poll();
                }else {
                    queue.add(queue.poll());
                }
            }
        }
        return x;
    }
}
