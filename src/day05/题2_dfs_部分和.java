package day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/4/2 15:01
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=118
 */


/**
 * 给出n个数，给出和k，能否选出若干个数，使他们的和为k
 */
public class 题2_dfs_部分和 {

    private static int kk;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int k = input.nextInt();
        kk = k;
        dfs(a, k, 0, new ArrayList<>());
    }

    static void dfs(int[] arr, int k, int cur, List<Integer> ints) {
        if (k == 0) {
            System.out.print("Yes (" + kk + "=");
            int size = ints.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ints.get(i) + (i == size - 1 ? "" : "+"));
            }
            System.out.print(")");
            System.exit(0);
        }
        if (k < 0 || cur == arr.length) {
            return;
        }
        //不要cur元素
        dfs(arr, k, cur + 1, ints);
        ints.add(arr[cur]);
        int index = ints.size() - 1;
        dfs(arr, k - arr[cur], cur + 1, ints);
        //回溯
        ints.remove(index);
    }
}
