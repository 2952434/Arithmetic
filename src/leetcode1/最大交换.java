package leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/9/13 16:08
 * @role:
 */
public class 最大交换 {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        int[] arr=new int[String.valueOf(num).length()];
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = num % 10;
            arr[i] = x;
            num = num /10;
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int max  = Integer.MIN_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (max<=arr[j]){
                    max = arr[j];
                    index = j;
                }
            }
            if (arr[index] == arr[i]){
                continue;
            }
            max = arr[index];
            arr[index] = arr[0];
            arr[i] = max;
            break;
        }

        int he = 0;
        for (int i = 0; i < arr.length; i++) {
            he = arr[i]*((int)Math.pow(10,arr.length - 1 - i))+ he;
        }
        return he;
    }
}
