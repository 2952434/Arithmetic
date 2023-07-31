package day05;

import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/4/2 17:31
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=121
 */
public class 题5_dfs_素数环 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] r = new int[n];
        r[0] = 1;
        dfs(n,r,1);
    }

    private static void dfs(int n, int[] r, int cur) {
        //填到末尾了，还有首尾相加为素数才算成功
        if (cur==n&&isP(r[0] + r[n-1])){
            print(r);
            return;
        }
        //尝试用每个数字填到cur这个位置
        for (int i = 2; i <= n; i++){
            //r中没有i这个数，且和上一个数之和为素数
            if (check(r,i,cur)){
                //试着将i放在cur位置，往前走一步
                r[cur] = i;
                dfs(n,r,cur+1);
                //回溯
                r[cur] = 0;
            }
        }
    }

    private static boolean check(int[] r, int i, int cur) {
        for (int e : r) {
            if (e==i||!isP(r[cur-1]+i)){
                return false;
            }
        }
        return true;
    }

    private static boolean isP(int k) {
        for (int i = 2; i*i <= k;i++){
            if (k%i == 0){
                return false;
            }
        }
        return true;
    }

    private static void print(int[] r) {

        for (int i = 0; i < r.length;i++){
            System.out.print(r[i] + (i==r.length-1? "" : " "));
        }
        System.out.println();
    }
}
