package day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/4/3 11:18
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=126
 */
public class 题2_贪心_快速渡河问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < n; j++) {
                speed[j] = sc.nextInt();
            }
            Arrays.sort(speed);
            f(n,speed);
        }

    }

    private static void f(int n, int[] speed) {
        int left = n;
        int ans = 0;
        while (left>0){
            if (left==1){
                ans += speed[0];
                break;
            }else if (left==2){
                ans += speed[1];
                break;
            }else if (left==3){
                ans += speed[2] + speed[0] +speed[1];
                break;
            }else {
                // 1,2出发，1返回，最后两名出发，2返回
                int s1 = speed[1] + speed[0] + speed[left-1] + speed[1];
                //1,3出发，1返回，1,4出发1返回
                int s2 = speed[left-1] + speed[left - 2] + 2*speed[0];

                ans += Math.min(s1,s2);
                left -= 2;
            }
        }
        System.out.println(ans);
    }

}
