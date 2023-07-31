package leetcode1;

/**
 * @Author: Ljx
 * @Date: 2022/7/12 9:27
 * @role:
 */
public class 奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for (int[] index : indices) {
            int r = index[0];
            int c = index[1];
            for (int j = 0; j < arr[r].length; j++) {
                arr[r][j] = arr[r][j] + 1;
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j][c] = arr[j][c] + 1;
            }
        }
        int x = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt % 2 == 1) {
                    x++;
                }
            }
        }
        return x;
    }
}
