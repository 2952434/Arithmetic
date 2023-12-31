package 暴力递归;

/**
 * @Author: Ljx
 * @Date: 2023/4/18 9:57
 * @role: 纸牌游戏
 */
public class Code04_CardsInLine {
    public int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr,0,arr.length - 1),s(arr,0,arr.length - 1));
    }

    private int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr,i + 1,j),arr[j] + s(arr,i,j-1));
    }

    private int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr,i + 1,j),f(arr,i,j-1));
    }
}
