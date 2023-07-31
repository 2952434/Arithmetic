package 图;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Ljx
 * @Date: 2023/4/16 16:13
 * @role:
 */
public class Code06_Dijkstra {
    public Map<Node,Integer> dijkstra(Node head) {
        //从head出发到所有点的最小距离
        // key : 从head出发到达key
        // value : 从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从head出发到T这个点的距离为正无穷
        Map<Node,Integer> distabceMap = new HashMap<>();
        distabceMap.put(head,0);
        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        Set<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distabceMap,selectedNodes);
        while (minNode != null) {
            int distance = distabceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distabceMap.containsKey(toNode)) {
                    distabceMap.put(toNode,distance + edge.weight);
                }else {
                    distabceMap.put(toNode,Math.min(distabceMap.get(toNode),distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distabceMap, selectedNodes);
        }
        return distabceMap;


    }

    private Node getMinDistanceAndUnselectedNode(Map<Node, Integer> distabceMap, Set<Node> selectedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distabceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
