package leetcode1;

/**
 * @Author: Ljx
 * @Date: 2023/4/19 11:00
 * @role:
 */
public class 分隔数组以得到最大和 {

    public static void main(String[] args) {
        分隔数组以得到最大和 s = new 分隔数组以得到最大和();
        System.out.println(s.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        process(arr,k,0,0);
        return max;
    }

    static int max = Integer.MIN_VALUE;

    public void process(int[] arr,int k,int startIndex,int maxValue){
        if (startIndex == 4){
            System.out.println(startIndex);
        }
        for (int i = 1; i <= k; i++) {
            int x = maxValue;
            int arrMax = getMax(arr, startIndex, i-1);
            for (int j = 0; j < i; j++) {
                x += arrMax;
            }
            if (startIndex + i==arr.length) {
                max = Math.max(x,max);
                return;
            }else if (startIndex +i > arr.length) {
                return;
            }else {
                process(arr,k,startIndex + i, x);
            }
        }
    }

    public int getMax(int[] arr,int start,int k){
        int max = 0;
        for (int i = 0; i <= k; i++) {
            max = Math.max(arr[start + i], max);
        }
        return max;
    }
}
