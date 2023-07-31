package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/4/26 23:17
 * @role:
 */
public class 三维形体投影面积 {
    public static void main(String[] args) {

    }

    public int projectionArea(int[][] grid) {
        int xy = 0;
        int xz = 0;
        int yz = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            int max1 = 0;
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max,grid[i][j]);
                max1 = Math.max(max1,grid[j][i]);
                if (grid[i][j]!=0){
                    xy++;
                }
            }
            xz += max;
            yz += max1;
        }
        return xy+xz+yz;
    }
}
