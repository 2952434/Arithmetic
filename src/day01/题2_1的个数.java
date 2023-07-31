package day01;

import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/3/27 10:15
 * @role:
 */

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 */

public class 题2_1的个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(Integer.toString(N, 2));

        /**
         * 方法一
         */
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((N&(1<<i))==(1<<i)){
                count++;
            }
        }
        System.out.println(count);


        /**
         *  方法二
         */
        count = 0;
        for (int i = 0; i < 32; i++) {
            if (((N>>i)&1)==1){
                count++;
            }
        }
        System.out.println(count);

        /**
         * 方法三
         */
        count = 0;
        while (N!=0){
            N = (N-1)&N;
            count++;
        }
        System.out.println(count);
    }
}
