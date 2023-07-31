package niuke;

import until.ListNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: Ljx
 * @Date: 2023/4/13 8:22
 * @role:
 */
public class day03 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(arr[0]);
        ListNode h1 = head;
        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        mostFrequentEven(new int[]{2,10000,10000,10000,2});
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode last = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            last = last.next;
            if (fast==last){
                return true;
            }
        }
        return false;
    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int j : nums) {
            if (j%2==0){
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        int num = 0;
        int ran = -1;
        while (iterator.hasNext()){
            int key = iterator.next();;
            Integer integer = map.get(key);
            if (integer>num){
                ran = key;
                num = integer;
            }else if (integer == num){
                ran = Math.min(ran,key);
            }
        }
        return ran;
    }

}
