package leetcodecompetition;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2023/5/14 11:37
 * @role:
 */
public class 统计完全连通分量的数量 {
    public int countCompleteComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {
            List<Integer> orDefault = map.getOrDefault(edges[i][0], new ArrayList<>());
            orDefault.add(edges[i][1]);
            map.put(edges[i][0],orDefault);
        }
        int x = 0;
        c:for (int i = 0; i < edges.length; i++) {
            if (set.contains(edges[i][0])) {
                continue;
            }
            set.add(edges[i][0]);
            List<Integer> list = map.get(edges[i][0]);
            for (int j = 0; j < list.size(); j++) {
                if (map.getOrDefault(list.get(j),new ArrayList<>()).size() != list.size()) {
                    continue c;
                }
                set.add(list.get(j));
            }
            x++;
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)){
                x++;
            }
        }
        return x;
    }


}
