package until;

import java.util.HashMap;
import java.util.Map;

class MajorityChecker {
    int[] arr;
    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }
    
    public int query(int left, int right, int threshold) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = left; i <= right; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
            if (map.get(arr[i]) == threshold) {
                return arr[i];
            }
        }
        return -1;
    }
}