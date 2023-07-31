package 贪心;

import java.util.PriorityQueue;

/**
 * @Author: Ljx
 * @Date: 2023/4/17 10:17
 * @role:
 */
public class Code01_LessMoneySplitGold {

    public int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
