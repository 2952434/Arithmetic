package leetcode.其他;

import java.util.Random;

/**
 * @Author: Ljx
 * @Date: 2022/6/5 16:12
 * @role:
 */
class Solution {
    Random random;
    double xc, yc, r;

    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        double u = random.nextDouble();
        double theta = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(u);
        return new double[]{xc + r * Math.cos(theta) * this.r, yc + r * Math.sin(theta) * this.r};
    }
}

public class 在圆内随机生成点 {
    public static void main(String[] args) {
        Random r = new Random();
        int max=500;//最大500 最大最小数可调
        int min=-400;//最小400 最大最小数可调
        double ran= (Math.random() * (max - min + 1) + min);
        System.out.println(ran);
    }
}
