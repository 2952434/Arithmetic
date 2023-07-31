package day01;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/3/27 15:38
 * @role:
 */
public class 题6_递归 {

    /**
     * n的阶乘
     * @param n
     * @return
     */
    static int f1(int n){
        if (n==1){
            return 1;
        }
        return n + f1(n-1);
    }

    /**
     * 打印i到j
     * @param i
     * @param j
     */
    static void f2(int i,int j){
        if (i>j){
            return;
        }
        System.out.println(i);
        f2(i+1,j);
    }

    /**
     * 对数组求和
     * @param arr
     * @param begin
     * @return
     */
    static int f3(int[] arr,int begin){
        if (begin==arr.length-1){
            return arr[begin];
        }
        return arr[begin]+f3(arr,begin+1);
    }
    /**
     * 字符串翻转
     * @param s
     * @param end
     * @return
     */
    static String reverse(String s,int end){
        if (end==0){
            return s.charAt(end)+"";
        }
        return s.charAt(end)+reverse(s,end-1);
    }

    static int[] arr = new int[10];
    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    static int fab(int n){
        if (n==1||n==2){
            return 1;
        }
        if (arr[n]>0){
            return arr[n];
        }
        arr[n] = fab(n-1)+fab(n-2);
        return arr[n];
    }

    /**
     * 最大公约数
     * @param m
     * @param n
     * @return
     */
    static int gcd(int m,int n){
        if (n==0){
            return m;
        }
        return gcd(n,m%n);
    }

    /**
     * 插入排序
     * @param arr
     * @param k
     * @return
     */
    static int[] insertSort(int[] arr, int k){
        if (k==0){
            return arr;
        }
        int[] ints = insertSort(arr, k - 1);
        int x = ints[k];
        int index = k-1;
        while (index>=0 && x<ints[index]){
            ints[index+1] = ints[index];
            index--;
        }
        ints[index+1] = x;
        return ints;
    }

    /**
     * 二分查找递归
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return
     */
    static int binarySearch1(int[] arr,int low,int high,int key){
        int mid = low + ((high-low)>>1);
        int midVal = arr[mid];
        if (midVal<key){
            return binarySearch1(arr,mid+1,high,key);
        }else if (midVal>key){
            return binarySearch1(arr, low, high-1, key);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Arrays.fill(arr,-1);
        String s = "abcd";
        System.out.println(reverse(s, s.length() - 1));

        System.out.println(fab(5));

        System.out.println(gcd(4, 2));

        int[] arr = {2,43,56,1,31,542,54,546,2};
        System.out.println(Arrays.toString(insertSort(arr,arr.length-1)));

        System.out.println(binarySearch1(arr, 0, arr.length - 1, 1));

        System.out.println(fab(4));
    }
}
