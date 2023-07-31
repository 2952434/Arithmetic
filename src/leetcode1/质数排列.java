package leetcode1;

/**
 * @Author: Ljx
 * @Date: 2022/6/30 16:01
 * @role:
 */
public class 质数排列 {
    public static void main(String[] args) {

    }
    static final int MOD = 1000000007;
    public int numPrimeArrangements(int n) {
        int i = numPrime(n);
        return (int) (factorial(i)*factorial(n-i)%MOD);
    }

    public int numPrime(int n){
        int x = 0;
        c:for (int i = 2; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt*sqrt==i){
                continue;
            }
            while (sqrt>1){
                if (i%sqrt==0){
                    continue c;
                }else {
                    sqrt--;
                }
            }
            if (sqrt==1){
                x++;
            }
        }
        return x;
    }
    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }

}
