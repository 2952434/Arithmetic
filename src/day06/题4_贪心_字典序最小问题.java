package day06;

import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/4/4 18:04
 * @role:
 */
public class 题4_贪心_字典序最小问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < N; i++) {
            ss.append(sc.next());
        }
        f(ss.toString());
    }

    private static void f(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        int N = s.length();
        StringBuilder rs = new StringBuilder();
        int cnt = 0;
        while (rs.length()<N){
            if (s.compareTo(s1)<=0){
                rs.append(s.charAt(0));
                s = s.substring(1);
            }else {
                rs.append(s1.charAt(0));
                s1 = s1.substring(1);
            }
            if (rs.length()%80==0){
                System.out.println(rs.substring(cnt*80,(cnt+1)*80));
                cnt++;
            }
        }
        if (rs.length()>cnt*80){
            System.out.println(rs.substring(cnt*80));
        }
    }
}
