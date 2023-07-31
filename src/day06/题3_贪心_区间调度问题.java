package day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/4/3 17:40
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=127
 */
public class 题3_贪心_区间调度问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(s[i],t[i]);
        }
        Arrays.sort(jobs);
        int res = f(n,jobs);
        System.out.println(res);
    }

    private static int f(int n, Job[] jobs) {
        int cnt = 1;
        int y = jobs[0].t;
        for (int i = 0; i < n; i++) {
            if (jobs[i].s>y){
                cnt++;
                y = jobs[i].t;
            }
        }
        return cnt;
    }


    static class Job implements Comparable<Job>{

        int s;
        int t;

        public Job(int s, int t){
            this.s = s;
            this.t = t;
        }
        @Override
        public int compareTo(Job o) {
            int x = this.t - o.t;
            if (x==0){
                return this.s - o.s;
            }else {
                return x;
            }
        }
    }

}

