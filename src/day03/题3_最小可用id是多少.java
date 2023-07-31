package day03;

/**
 * @Author: Ljx
 * @Date: 2022/3/29 22:35
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=43
 */
public class 题3_最小可用id是多少 {

    public static void main(String[] args) {
        int[] arr = {1,23,143,45,31,2325,4131,15,55,324,233,13,25,43};
        System.out.println(find(arr));
    }
    static int find(int[] arr){
        int n = arr.length;
        int[] helper = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (arr[i]<n+1){
                helper[arr[i]] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (helper[i]==0){
                return i;
            }
        }
        return n+1;
    }
}
