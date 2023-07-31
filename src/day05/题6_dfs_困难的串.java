package day05;

/**
 * @Author: Ljx
 * @Date: 2022/4/2 17:59
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=122&spm_id_from=pageDriver
 */
public class 题6_dfs_困难的串 {

    public static void main(String[] args) {
        int n = 10;
        int l = 4;
        dfs(l,n,"");
    }

    static int count;
    private static void dfs(int l, int n, String prefix) {
        //尝试在prefix后追加一个字符
        for (char i = 'A'; i< 'A' + l; i++){
            //是困难的串就组合起来输出
            if (isHard(prefix,i)){
                String x = prefix + i;
                System.out.println(x);
                count ++;
                if (count == n){
                    System.exit(0);
                }
                dfs(l,n,x);
            }
        }
    }

    /**
     * 判断prefix+i是否一个困难的串
     * 1.遍历所有的长度为偶数的子串,看是否对称
     * 2.prefix是一个困难的串 ABACA i
     * @param prefix
     * @param i
     * @return
     */
    private static boolean isHard(String prefix, char i) {
        //截取的宽度
        int count = 0;
        for (int j = prefix.length() - 1; j>= 0; j-= 2){
            final String s1 = prefix.substring(j,j+count+1);
            final String s2 = prefix.substring(j+count+1) +i;
            if (s1.equals(s2)){
                return false;
            }
            count++;
        }
        return true;
    }
}
