package leetcode1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Ljx
 * @Date: 2022/7/8 9:02
 * @role:
 */
public class 玩筹码 {

    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{1,2,3}));
    }

    public static int minCostToMoveChips(int[] position) {

        int x = 0;
        int y = 0;
        for (Integer key : position) {
            if (key%2==1){
                x++;
            }else {
                y++;
            }

        }
        return Math.min(x,y);

    }
}
