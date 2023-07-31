package 图;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2023/4/16 11:13
 * @role:
 */
public class Code04_kruskal {

    public static class MySets{
        public HashMap<Node, List<Node>> setMap = new HashMap<>();

        public MySets(List<Node> nodes) {
            for (Node cur : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }

        public boolean isSameSet(Node from,Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from,Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }
    }

    public Set<Edge> kruskalMST(Graph graph) {
        MySets mySets = new MySets((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        priorityQueue.addAll(graph.edges);
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!mySets.isSameSet(edge.from,edge.to)) {
                result.add(edge);
                mySets.union(edge.from,edge.to);
            }
        }
        return result;
    }

}
