package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/6/17 9:55
 * @role:
 */
public class 复写零 {
    public static void main(String[] args) {

//        duplicateZeros(new int[]{1,2});
        Map<String,String> map1 = new HashMap<>();
        map1.put("aasd","dasd");
        Map<String,Object> map = new HashMap<>();
        map.put("asd","123");
        map.put("rep",map1);
        System.out.println(map);

    }
    public static void duplicateZeros(int[] arr) {
        int[] ints = Arrays.copyOf(arr, arr.length);
        int x = 0;
        for (int i = 0; i < ints.length; i++) {
            if (i+x>=arr.length){
                return;
            }

            arr[i+x] = ints[i];
            if (ints[i]==0){
                x++;
                if (i+x>=arr.length){
                    return;
                }
                arr[i+x] = 0;
            }
        }
    }
}
