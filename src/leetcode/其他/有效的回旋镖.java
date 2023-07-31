package leetcode.其他;


/**
 * @Author: Ljx
 * @Date: 2022/6/8 17:09
 * @role:
 */
public class 有效的回旋镖 {
    public static void main(String[] args) {
        isBoomerang(new int[][]{{0,1},{2,2},{2,0}});
    }
    public static boolean isBoomerang(int[][] points) {

        if (points.length!=3){
            return false;
        }
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i][0]==points[j][0]&&points[i][1]==points[j][1]){
                    return false;
                }
            }
        }
        if (points[0][0]==points[1][0]&&points[1][0]==points[2][0]){
            return false;
        }
        if (points[0][1]==points[1][1]&&points[1][1]==points[2][1]){
            return false;
        }
        double x = points[1][0] - points[0][0];
        double y = points[1][1] - points[0][1];
        double x1 = points[2][0] - points[0][0];
        double y1 = points[2][1] - points[0][1];

        return x==0||y==0||x1==0||y1==0||y1 / x1 != y / x;

    }
}
