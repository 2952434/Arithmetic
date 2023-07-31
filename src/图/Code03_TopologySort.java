package 图;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2023/4/16 10:52
 * @role: 拓扑排序
 */
public class Code03_TopologySort {

    public List<Node> sortedTology(Graph graph){
        //key: 某一个node
        //value: 剩余的入度
        HashMap<Node,Integer> inMap = new HashMap<>();
        // 入度为零的点进这个队列
        Queue<Node> zeroInQueue = new ArrayDeque<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node,node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next,inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
