package 暴力递归;

import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2023/4/18 9:00
 * @role: 汉诺塔问题
 */
public class Code01_Hanoi {


    public static void hanoi(int n) {
        if (n > 0){
            func(n,"左","右","中");
        }
    }

    private static void func(int i, String start, String end, String other) {
        if (i == 1) {
            System.out.println("Move 1 from" + start + "to" + end);
        }else {
            func(i - 1,start,other,end);
            System.out.println("Move" + i + "from" + start + "to" + end);
            func(i -1, other, end,start);
        }
    }



    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A.size() > 0){
            func(A.size(),A,C,B);
        }
    }
    private static void func(int i, List<Integer> A, List<Integer> C, List<Integer> B) {
        if (i == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }else {
            func(i - 1,A,B,C);
            C.add(A.remove(A.size() - 1));
            func(i -1, B, C,A);
        }
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
