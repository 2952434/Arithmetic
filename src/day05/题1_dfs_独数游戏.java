package day05;


import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/4/1 21:20
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=117&spm_id_from=pageDriver
 */
public class 题1_dfs_独数游戏 {

    public static void main(String[] args) {
        char[][] table = new char[9][9];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < table.length; i++) {
            table[i] = input.nextLine().toCharArray();
        }
        dfs(table,0,0);
    }


    static void dfs(char[][] table, int x, int y) {
        if (x == 9) {
            print(table);
            System.exit(0);
        }
        //虚位以待
        if (table[x][y] == '0') {
            for (int k = 1; k < 10; k++) {
                if (check(table, x, y, k)) {
                    table[x][y] = (char) ('0' + k);
                    //处理下一个状态
                    dfs(table, x + (y + 1) / 9, (y + 1) % 9);
                }
            }
            //回溯
            table[x][y] = '0';
        } else {
            //处理下一个状态
            dfs(table, x + (y + 1) / 9, (y + 1) % 9);
        }
    }

    static void print(char[][] table) {
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(table[i]));
        }
    }

    private static boolean check(char[][] table, int i, int j, int k) {
        //检查同行和同列
        for (int l = 0; l < 9; l++) {
            if (table[i][l] == (char) ('0' + k)) {
                return false;
            }
            if (table[l][j] == (char) ('0' + k)) {
                return false;
            }
        }
        //检查小九宫格
        for (int l = (i / 3) * 3; l < (i / 3 + 1) * 3; l++) {
            for (int m = (j / 3) * 3; m < (j / 3 + 1) * 3; m++) {
                if (table[l][m] == (char) ('0' + k)) {
                    return false;
                }
            }
        }
        return true;
    }
}
