package day01;

/**
 * @Author: Ljx
 * @Date: 2022/3/27 10:25
 * @role:
 */

import java.util.Scanner;

/**
 * 用一条语句判断一个整数是不是2的整数次方
 */
public class 题3_是不是2的整数次方 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println((i-1&i)==0);
    }
}
