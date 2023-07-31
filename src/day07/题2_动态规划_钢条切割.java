package day07;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/4/4 22:40
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=136
 */
public class 题2_动态规划_钢条切割 {

    static int n =10;
    static int[] p = {1,5,8,16,10,17,17,20,24,30};
    static int[] vs = new int[n+1];
    /**
     *  有大量重复
     * @param x 钢条的长度
     * @return int
     */
    static int r(int x){
        if (x==0){
            return 0;
        }
        int ans = 0;

        for (int i = 1; i <= x; i++) {
            int v= p[i-1] + r(x-i);
            ans = Math.max(v,ans);
        }
        return ans;
    }


    /**
     *  记忆型递归
     * @param x 钢条的长度
     * @return int
     */
    static int r1(int x){
        if (x==0){
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= x; i++) {
            if (vs[x-i]==-1){
                vs[x-i] = r1(x-i);
            }
            int v= p[i-1] + vs[x-i];
            ans = Math.max(v,ans);
        }
        vs[x] = ans;
        return ans;
    }

    /**
     * 动态规划dp
     * @return int
     */
    static int dp(){
        vs[0] = 0;
        //拥有的钢条长度
        for (int i = 1; i <= n; i++) {
            //保留j为整数
            for (int j = 1; j <= i; j++) {
                vs[i] = Math.max(p[j-1]+vs[i-j],vs[i]);
            }
        }
        return vs[n];
    }

    public static void main(String[] args) {
        System.out.println(r(n));
        Arrays.fill(vs,-1);
        System.out.println(r1(n));
        System.out.println(dp());
    }
}
