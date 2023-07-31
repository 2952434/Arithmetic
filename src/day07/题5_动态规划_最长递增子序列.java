package day07;

/**
 * @Author: Ljx
 * @Date: 2022/4/6 20:11
 * @role:
 */
public class 题5_动态规划_最长递增子序列 {
    static int[] arr = {123,34,4,234,56,1};

    public static void main(String[] args) {
        System.out.println(dp(arr));
        System.out.println(dp1(arr));
    }



    static int[] dp = new int[arr.length];
    /**
     * 动态规划化
     * @param arr
     * @return
     */
    static int dp(int[] arr){
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int cnt = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i]>arr[j]){
                    cnt = Math.max(cnt,dp[j]+1);
                }
            }
            dp[i] = cnt;
        }
        int ans = -1;
        for (int j : dp) {
            ans = Math.max(ans, j);
        }
        return ans;
    }

    static int dp1(int[] arr){
        dp = new int[arr.length+1];
        //长度为1的最长递增子序列，初始化为第一个元素
        dp[1] = arr[0];
        //记录dp更新的最后位置
        int p = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>dp[p]){
                dp[p+1] = arr[i];
                p++;
            }else {
//                //扫描dp数组，替换第一个比arr[i]大的dp
//                for (int j = 0; j <=p; j++) {
//                    if (dp[j]>arr[i]){
//                        dp[j] = arr[i];
//                    }
//                }
//                利用二分查找优化
                int right = p;
                int left = 1;
                while (right>left){
                    int mid = left + ((right-left)>>1);
                    if (dp[mid]<arr[i]){
                        left = mid + 1;
                    }else {
                        right = mid -1;
                    }
                }
                dp[left] = arr[i];
            }
        }
        return p;
    }
}
