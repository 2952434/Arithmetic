package day06;


import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Ljx
 * @Date: 2022/4/3 9:12
 * @role:
 */
public class 题1_贪心_硬币支付问题 {

    static int [] cnts = new int[6];
    static int[] coins = {1,5,10,50,100,500};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            cnts[i] = input.nextInt();
        }
        int A = input.nextInt();
        int res = f(A,5);
        System.out.println(res);
    }

    /**
     * 尽量先用大面值，因为不用大面值将使用更多的小面值硬币，一定得不到最优解
     * @param A
     * @param cur
     * @return
     */
    private static int f(int A, int cur) {
       if (A<=0){
           return 0;
       }
       if (cur==0){
           return A;
       }
       int coinValue = coins[cur];
       //金额有多少个coinValue
       int x = A / coinValue;
       //当前面值的硬币有cnt个
       int cnt = cnts[cur];
       int t = Math.min(x,cnt);
       return t+f(A-t*coinValue,cur-1);
    }


}