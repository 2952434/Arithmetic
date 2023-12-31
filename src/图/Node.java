package 图;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Ljx
 * @Date: 2023/4/16 9:58
 * @role: 结点
 */
public class Node {

    public int value;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return value == node.value && in == node.in && out == node.out && Objects.equals(nexts, node.nexts) && Objects.equals(edges, node.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, in, out, nexts, edges);
    }
}
