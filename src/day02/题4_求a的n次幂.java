package day02;

/**
 * @Author: Ljx
 * @Date: 2022/3/28 21:41
 * @role:
 */
public class 题4_求a的n次幂 {
    public static void main(String[] args) {
        System.out.println(Math.pow(4, 4));
        System.out.println(pow(4,4));
    }

    static int pow(int a,int n){
        if (n==0){
            return 1;
        }
        int res = a;
        int ex = 1;
        while ((ex<<1)<=n){
            res *= res;
            ex<<=1;
        }
        return res*pow(a,n-ex);
    }


    static long pow2(long n,long m){
        //n的1次方
        long  pigFangShu = n;
        long result = 1;

        while (m!=0){
            //遇1累乘现在的幂
            if ((m&1) == 1){
                result *= pigFangShu;
            }
            //每移位一次，幂累乘方一次
            pigFangShu = pigFangShu*pigFangShu;
            //右移一位
            m>>=1;
        }
        return result;
    }
}
