package 面试;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2023/4/14 19:32
 * @role: https://www.bilibili.com/video/BV1DT411s7hp?p=9&spm_id_from=pageDriver&vd_source=dd175df01f695b63c916dc1b6fd97755
 */
public class t01 {

    public static int process(int[][] arr,int index,int resFunny,int restOffense) {
        if (resFunny <= 0 && restOffense <= 0) {
            return 0;
        }
        if (index == arr.length) {
            return Integer.MAX_VALUE;
        }
        int p1 = process(arr,index + 1,resFunny,restOffense);
        int p2 = Integer.MAX_VALUE;
        int next = process(arr,index + 1,resFunny - arr[index][0],restOffense - arr[index][1]);
        if (next != Integer.MAX_VALUE) {
            p2 = next + 1;
        }
        return Math.min(p1,p2);
    }

    public static int maxValue(int[][] arr,int index,int restLen){
        if (restLen < 0 || index == arr.length) {
            return 0;
        }
        // 不选当前方案
        int p1 = maxValue(arr, index + 1, restLen);
//        选当前方案
        int p2 = 0;
        if (arr[index][0] <= restLen) {
            p2 = arr[index][1] + maxValue(arr,index, restLen - arr[index][0]);
        }
        return Math.max(p1,p2);
    }

    public static int maxLan(int[][] arr,int index,int preIndex) {
        if (index == arr.length) {
            return 0;
        }
        int p1 = maxLan(arr,index + 1, preIndex);
        int p2 = 0;
        if (arr[preIndex][1] == arr[index][0]) {
            p2 = 1 + maxLan(arr,index + 1,index);
        }
        return Math.max(p1,p2);
    }

    public int solve (char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    clear(grid,i,j);
                    num++;
                }
            }
        }
        return num;
    }

    public void clear(char[][] arr,int i,int j){
        if (i==arr.length || i < 0 || j == arr[i].length || j < 0 || arr[i][j] == '0'){
            return;
        }else {
            arr[i][j] = '0';
        }
        clear(arr,i - 1,j);
        clear(arr,i + 1,j);
        clear(arr,i,j + 1);
        clear(arr,i,j - 1);
    }


    public static ArrayList<String> Permutation(String str) {
        char[] arr = str.toCharArray();

        Set<String> strings = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        getList(strings,arr,"",set);
        return new ArrayList<>(strings);
    }

    public static void getList(Set<String> list, char[] arr, String s, Set<Integer> set){
        if (s.length() == arr.length) {
            list.add(s);
        }
        if (set.size() == arr.length) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean contains = set.contains(i);
            if (contains) {
                continue;
            }
            set.add(i);
            getList(list,arr,s + arr[i],set);
            set.remove(i);
        }
    }


    public static int minTimes(int[] arr) {
        int[] cnt = new int[3];
        for (int num : arr) {
            cnt[num]++;
        }
        if (cnt[0] == cnt[1] && cnt[0] == cnt[2]){
            return 0;
        }
        int n = arr.length;
        int m = n / 3;
        if ((cnt[0] < m && cnt[1] < m) || (cnt[0] < m && cnt[2] < m) || (cnt[2] < m && cnt[1] < m)){
            return 2;
        }else {
            return once(arr,cnt,m) ? 1 : 2;
        }
    }

    private static boolean once(int[] arr, int[] cnt, int m) {
        int lessV = cnt[0] < m ? 0 : (cnt[1] < m ? 1 : 2);
        int lessT = lessV == 0 ? cnt[0] : (lessV == 1 ? cnt[1] : cnt[2]);

        if (cnt[0] > m && modify(arr,0,cnt[0],lessV,lessT)){
            return true;
        }
        if (cnt[1] > m && modify(arr,1,cnt[1],lessV,lessT)){
            return true;
        }
        return cnt[2] > m && modify(arr, 2, cnt[2], lessV, lessV);
    }


    private static boolean modify(int[] arr, int more, int moreT, int less, int lessT) {
        int[] cnt = new int[3];
        cnt[less] = lessT;
        cnt[more] = moreT;
        int aim = arr.length / 3;
        int L = 0;
        int R = 0;
        while (R < arr.length || cnt[more] <= aim) {
            if (cnt[more] > aim) {
                cnt[arr[R++]]--;
            }else if (cnt[more] < aim) {
                cnt[arr[L++]]++;
            }else {
                if (cnt[less] + R - L < aim) {
                    cnt[arr[R++]]--;
                }else if (cnt[less] + R - L > aim) {
                    cnt[arr[L++]]++;
                }else {
                    return true;
                }
            }
        }
        return false;
    }


    public static int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int[] path : paths) {
            List<Integer> list = map.computeIfAbsent(path[0]-1, k -> new ArrayList<>());
            list.add(path[1] - 1);
            List<Integer> list2 = map.computeIfAbsent(path[1]-1, k -> new ArrayList<>());
            list2.add(path[0] -1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] colored = new boolean[5];
            for (int vertex : map.computeIfAbsent(i, k -> new ArrayList<>())) {
                colored[ans[vertex]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!colored[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }


    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if ((sum & 3) != 0){
            return false;
        }
        int[] dp = new int[1 << matchsticks.length];
        return process(matchsticks,0,0,sum >> 2,4,dp);
    }

    private boolean process(int[] arr, int status, long sum, long len, int edges, int[] dp) {
        if (edges == 0){
            return status == (1 << arr.length) - 1 ? true : false;
        }
        if (dp[status] != 0){
            return dp[status] == 1;
        }
        boolean ans = false;
        for (int i = 0; i < arr.length; i++) {
            if ((status & (1 << i)) == 0) {
                if (sum + arr[i] <= len) {
                    if (sum + arr[i] < len) {
                        ans = process(arr,status | (1 << i),sum + arr[i],len,edges,dp);
                    }else {
                        ans = process(arr,status | (1 << i),0,len,edges - 1,dp);
                    }
                }
            }
            if (ans){
                break;
            }
        }
        dp[status] = ans ? 1 : -1;
        return ans;
    }


    public static void main(String[] args) {
        gardenNoAdj(3,new int[][]{{1,2},{2,3},{3,1}});
    }
}
