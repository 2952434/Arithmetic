package 图;

import day07.题1_动态规划_背包问题;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @Author: Ljx
 * @Date: 2023/4/16 10:32
 * @role:
 */
public class Code01_BFS {

    public void bfs(Node node) {
        if (node == null){
            return;
        }
        Queue<Node> queue  = new ArrayDeque<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
