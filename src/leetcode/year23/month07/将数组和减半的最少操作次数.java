package leetcode.year23.month07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 将数组和减半的最少操作次数 {

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o2,o1);
            }
        });
        double he = 0;
        for (int num : nums) {
            queue.add((double) num);
            he += num;
        }
        he /= 2;
        int ren = 0;
        double num = 0;
        double max = queue.poll();
        while (num < he) {
            max /= 2;
            num += max;
            queue.add(max);
            ren++;
            max = queue.poll();
        }
        return ren;
    }

    public static void main(String[] args) {
        System.out.println(halveArray(new int[]{6, 58, 10, 84, 35, 8, 22, 64, 1, 78, 86, 71, 77}));
    }
}
