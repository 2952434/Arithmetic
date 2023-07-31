package leetcode1;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/7/5 10:56
 * @role:
 */
public class 我的日程安排表I {

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(37, 50);
        System.out.println(myCalendar.book(33, 50));
        System.out.println(myCalendar.book(4, 17));
        System.out.println(myCalendar.book(35, 48));
        System.out.println(myCalendar.book(8, 25));
    }
}
class MyCalendar {
    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}

