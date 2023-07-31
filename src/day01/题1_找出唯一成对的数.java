package day01;

/**
 * @Author: Ljx
 * @Date: 2022/3/27 9:54
 * @role:
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 1-1000这1000个数放在含有1001个元素的数组中，只有唯一的一个元素值重复，
 * 其它均只出现一次。每个数组元素只能访问一次，设计一个算法，将它找出来;
 * 不用辅助存储空间，能否设计一个算法实现?
 */
public class 题1_找出唯一成对的数 {
    public static void main(String[] args) {
        int N = 1001;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = i + 1;
        }
//        最后一个数是随机数
        arr[arr.length-1] = new Random().nextInt(N-1)+1;


        /**
         * 使用set方法
         */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])){
                System.out.println(arr[i]);
            }else {
                set.add(arr[i]);
            }
        }

        /**
         * 使用二进制方法
         */
        int x1 = 0;
        for (int i = 1; i <= N - 1; i++) {
            x1 = (x1^i);
        }
        for (int i = 0; i < N; i++) {
            x1 = x1^arr[i];
        }
        System.out.println(x1);
    }
}
