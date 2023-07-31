package day01;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/3/27 18:05
 * @role:
 */
public class 题7_希尔排序 {
    public static void main(String[] args) {
        int[] arr= {9,7,6,4,231,123,54,55466,86};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void shellSort(int[] arr){
        for (int interval = arr.length/2; interval > 0; interval/=2) {
            for (int i = interval; i < arr.length; i++) {
                int i1 = arr[i];
                int index = i-interval;
                while (index>=0&&arr[index]>arr[i]){
                    arr[index+interval] = arr[index];
                    index-=interval;
                }
                arr[index+interval] = i1;
            }
        }
    }
}
