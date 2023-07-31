package day02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/3/28 18:00
 * @role:
 */

/**
 * 小白正在上楼梯，楼梯有n阶台阶，小白一次可以上1阶，2阶或者3阶，
 * 实现一个方法，计算小白有多少种走完楼梯的方式。
 */
public class 题1_小白上楼梯 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            arr = new int[n + 1];
            Arrays.fill(arr, -1);
            System.out.println(f(n));
            System.out.println(f1(n));
            System.out.println(method(n));
        }

    }

    /**
     * 递归 可用记忆性递归优化
     *
     * @param n
     * @return
     */
    private static int f(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        return f(n - 1) + f(n - 2) + f(n - 3);
    }


    static int[] arr;

    /**
     * 记忆性递归
     *
     * @param n
     * @return
     */
    private static int f1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = f1(n - 1) + f1(n - 2) + f1(n - 3);
        return arr[n];
    }


    /**
     * 一步可以走一阶或两阶或三阶  输入一个阶数, 有多少种走法
     * <p>
     * //递推呢就是自下而上,想问题和写程序都是从下往上 从小问题到问题
     * n=0	1
     * n=1	1
     * n=2	2
     * n=3	4 (前三项和:1+1+2)
     * n=4	7 (前三项和:1+2+4)
     * <p>
     * 因为如果n=4时 可以先走一步 那么还剩三步,n=3的结果已经算出来了为4
     * 如果先走两步,那么还剩两步,那么n=2的值已经算出来了为2
     * 如果先走三步,那么还剩一步,n=1的值为1
     * 所以当n为4时 有7种走法
     */
    static int x1 = 0;
    static int x2 = 0;
    static int x3 = 0;
    static int x_1 = 0;

    private static long method(int n) {

        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        x1 = 1;
        x2 = 2;
        x3 = 4;
        for (int i = 4; i <= n; i++) {
            x_1 = x1;
            x1 = x2;
            x2 = x3;
            x3 = (x1 + x2 + x_1);
        }
        return x3;
    }
}
