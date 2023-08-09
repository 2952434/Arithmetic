package leetcode.year23.month08;

/**
 * @Author: 李君祥
 * @create: 2023-08-09 9:38
 * @description:
 */
public class 整数的各位积和之差 {
    public int subtractProductAndSum(int n) {
        int j = 1;
        int h = 0;

        while (n != 0) {
            int i = n % 10;
            j *= i;
            h += i;
            n /= 10;
        }
        return j - h;
    }
}
