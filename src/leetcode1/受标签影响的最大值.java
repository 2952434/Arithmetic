package leetcode1;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2023/5/23 10:21
 * @role:
 */
public class 受标签影响的最大值 {
    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<Value> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(new Value(values[i], labels[i]));
        }
        list.sort(new Comparator<Value>() {
            @Override
            public int compare(Value o1, Value o2) {
                return o2.v - o1.v;
            }
        });
        int num = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Value value = list.get(i);
            Integer orDefault = map.getOrDefault(value.l, 0);
            if (orDefault < useLimit && numWanted > 0) {
                num += value.v;
                map.put(value.l, orDefault + 1);
                numWanted--;
            }
            if (numWanted == 0) {
                return num;
            }
        }
        return num;
    }

    static class Value {
        int v;
        int l;

        public Value() {
        }

        ;

        public Value(int v, int l) {
            this.v = v;
            this.l = l;
        }
    }

    public static void main(String[] args) {
        largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1);
    }
}
