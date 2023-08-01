package leetcode.year23.month07;

import java.util.ArrayList;
import java.util.List;

public class 交替数字和 {

    public int alternateDigitSum(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int i = n % 10;
            n /= 10;
            list.add(i);
        }
        int x = -1;
        int ren = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (x == -1) {
                ren = list.get(i);
                x = 0;
            } else if (x == 0) {
                ren -= list.get(i);
                x = 1;
            } else {
                ren += list.get(i);
                x = 0;
            }
        }
        return ren;
    }
}
