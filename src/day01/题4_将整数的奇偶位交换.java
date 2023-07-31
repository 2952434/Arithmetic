package day01;

/**
 * @Author: Ljx
 * @Date: 2022/3/27 10:35
 * @role:
 */
public class 题4_将整数的奇偶位交换 {

    public static void main(String[] args) {
        int a = 9;
        int b = m(a);
        System.out.println(Integer.toString(a, 2));
        System.out.println(Integer.toString(b, 2));
         hasAlternatingBits(4);

    }

    private static int m(int n){
        int ou = n&0xaaaaaaaa;
        int ji = n&0x55555555;
        return (ou>>1)^(ji<<1);
    }

    public static boolean hasAlternatingBits(int n) {
        int x = n&1;
        while (n!=0){
            x++;
            int i = x % 2;
            n = n>>1;
            if ((n&1)!=i){
                return false;
            }
        }
        return true;
    }
}
