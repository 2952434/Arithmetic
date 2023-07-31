package day05;

/**
 * @Author: Ljx
 * @Date: 2022/4/2 15:53
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=120
 */
public class 题4_dfs_n皇后问题 {

    static int n;
    static int cnt;
    static int[] rec;
    public static void main(String[] args) {
        n = 4;
        rec = new int[4];
        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int row){
        if (row == n){
            cnt ++;
            return;
        }
        //依次尝试在某列上放一个皇后
        for (int col = 0; col < n; col++) {
            boolean ok = true;
            //检验这个皇后是否和之前已经放置的皇后有冲突
            for (int i = 0; i < row; i++) {
                if (rec[i] == col || i+rec[i] == row + col || rec[i] -i ==col -row){
                    ok = false;
                    break;
                }
            }
            //这里可以认为是剪枝
            //这一行的这一列可以放
            if (ok){
                //标记
                rec[row] = col;
                //继续找下一行
                dfs(row+1);
//                rec[row] = 0; // 恢复原状 这种解法是否回复原状都行
            }
        }
    }
}
