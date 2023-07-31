package day04;

/**
 * @Author: Ljx
 * @Date: 2022/4/1 20:21
 * @role:
 */
public class 题7_全排列字典序第k个排列 {

    public static void main(String[] args) {

        String s = "abcd";
        for (int i = 0; i < s.length(); i++) {
            permutation(s.charAt(i)+"",s.toCharArray());
        }
    }

    final static int K = 3;
    static int count = 0;
    static void permutation(String prefix,char[] arr){
        if (prefix.length()==arr.length){
            count++;
            if (count==K){
                System.out.println("-------:" + prefix);
                System.exit(0);
            }
        }
        for (char ch : arr) {
            if (count(prefix, ch) < count(arr, ch)) {
                permutation(prefix + ch, arr);
            }
        }
    }
    static int count(char[] arr,char ch){
        int cnt = 0;
        for (char c : arr) {
            if (c==ch){
                cnt++;
            }
        }
        return cnt;
    }

    static int count(String prefix,char ch){
        int cnt = 0;
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i)==ch){
                cnt++;
            }
        }
        return cnt;
    }
}
