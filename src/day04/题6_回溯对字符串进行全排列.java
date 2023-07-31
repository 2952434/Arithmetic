package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/3/31 22:14
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=114
 */
public class 题6_回溯对字符串进行全排列 {

    public static void main(String[] args) {
        System.out.println(getPermutation("0123456789"));
        System.out.println(x);
    }

    static int x =0;
    static List<String> res = new ArrayList<>();
    static List<String> getPermutation(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        getPermutationCore(chars,0);
        return res;
    }

    static void getPermutationCore(char[] arr, int k){
        if (k == arr.length){
            x++;
           res.add(new String(arr));
        }
        for (int i = k; i < arr.length; i++) {
            //把后面的字符换到k位
           swap(arr,k,i);
           getPermutationCore(arr, k+1);
           //回溯
           swap(arr,k,i);
        }
    }

    static void swap(char[] arr,int i,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
