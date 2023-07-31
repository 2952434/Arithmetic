package leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/7/19 16:30
 * @role:
 */
public class 我的日程安排表II {

}

class MyCalendarTwo {
    List<int[]> booked ;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            int l = overlap[0];
            int r = overlap[1];
            if (l<end && start < r){
                return false;
            }
        }
        for (int[] ints : booked) {
            int l = ints[0];
            int r = ints[1];
             if (l<end && start < r){
                overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}
