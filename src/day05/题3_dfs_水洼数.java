package day05;

import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/4/2 15:24
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=119
 */
public class 题3_dfs_水洼数 {


    static int n = 0;
    static int m = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        char[][] a= new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextLine().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j]=='W'){
                    //清除一个水洼
                    dfs(a,i,j);
                    cnt++;
                }
            }
        }
    }

    static void dfs(char[][] a,int i,int j){
        a[i][j] = '.';
        for (int k = -1;k<2;k++){
            for (int l = -1; l < 2; l++) {
                if (k==0&&l==0){
                    continue;
                }
                if (i+k>=0&&i+k<=n-1&&j+l>=0&&j+l<=m-1){
                    if (a[j+k][j+l]=='W'){
                        dfs(a,i+k,j+l);
                    }
                }
            }
        }
    }
}
