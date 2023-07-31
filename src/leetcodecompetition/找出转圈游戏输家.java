package leetcodecompetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2023/5/14 10:33
 * @role:
 */
public class 找出转圈游戏输家 {
    public static int[] circularGameLosers(int n, int k) {
        int[] arr = new int[n];
        int i = 0;
        int x = 0;
        while (arr[i % n] == 0 ){
            x++;
            i %= n;
            arr[i] = 1;
            i += (k * x);

        }
        List<Integer> list = new ArrayList<>();
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] == 0) {
                list.add(i1 + 1);
            }
        }
        arr = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            arr[i1] = list.get(i1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = circularGameLosers(5, 2);
        System.out.println(Arrays.toString(ints));
    }
}
