package 图;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: Ljx
 * @Date: 2023/4/16 9:56
 * @role: 图
 */
public class Graph {

    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
