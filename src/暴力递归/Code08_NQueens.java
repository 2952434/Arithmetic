package 暴力递归;

/**
 * @Author: Ljx
 * @Date: 2023/4/17 11:43
 * @role:
 */
public class Code08_NQueens {

    public int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0,record,n);
    }

    private int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record,i,j)) {
                record[i] = j;
                res += process1(i + 1,record,n);
            }
        }
        return res;
    }

    private boolean isValid(int[] record, int i, int j) {

        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit,0,0,0);
    }

    private int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return -1;
        }
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~ pos + 1);
            pos = pos - mostRightOne;

            res += process2(limit,colLim | mostRightOne,(leftDiaLim | mostRightOne) << 1,(rightDiaLim | mostRightOne) >>>1 );
        }
        return res;
    }

    public static void main(String[] args) {
        int limit = (1 << 8) - 1;
        System.out.println(Integer.toBinaryString(limit));

        int colLim = (1<<3);
        System.out.println(Integer.toBinaryString(colLim));
        int leftDiaLim = (1<<4);
        System.out.println(Integer.toBinaryString(leftDiaLim));
        int rightDiaLim = (1<<2);
        System.out.println(Integer.toBinaryString(rightDiaLim));

        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        System.out.println(Integer.toBinaryString(pos));

        System.out.println(Integer.toBinaryString(~pos));

        System.out.println(Integer.toBinaryString((~pos + 1)));

        int mostRightOne = pos & (~pos + 1);

        System.out.println(Integer.toBinaryString(mostRightOne));
        pos = pos - mostRightOne;
        System.out.println(Integer.toBinaryString(pos));
        System.out.println(Integer.toBinaryString(~pos));

        System.out.println(Integer.toBinaryString((~pos + 1)));
        mostRightOne =  pos & (~pos + 1);
        System.out.println(Integer.toBinaryString(mostRightOne));

    }

}
