package leetcode.year23.month08;

/**
 * @Author: 李君祥
 * @create: 2023-08-11 9:05
 * @description:
 */
public class 矩阵对角线元素的和 {

    public int diagonalSum(int[][] mat) {
        int ren = 0;
        for (int i = 0; i < mat.length; i++) {
            int before = mat[i][i];
            int after = mat[i][mat.length - 1 - i];
            if (mat.length - 1 - i == i) {
                ren += before;
            }else {
                ren += before + after;
            }
        }
        return ren;
    }

}
