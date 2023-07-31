package leetcode1;

/**
 * @Author: Ljx
 * @Date: 2023/4/21 10:40
 * @role:
 */
public class 最小偶倍数 {

    public int smallestEvenMultiple(int n) {
        if (n%2==0 || n == 1) {
            return n;
        }else {
            return n * 2;
        }
    }
}
