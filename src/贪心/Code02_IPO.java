package 贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Ljx
 * @Date: 2023/4/17 10:28
 * @role:
 */
public class Code02_IPO {

    private static class Node{
        public int p;
        public int c;
        public Node(int p,int c) {
            this.p = p;
            this.c = c;
        }
    }

    public int findMaximizedCapital(int k,int w,int[] profits,int[] capital) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.c-o2.c;
            }
        });
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.p - o1.p;
            }
        });
        for (int i = 0; i < profits.length; i++) {
            minCostQ.add(new Node(profits[i], capital[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w){
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }


}
