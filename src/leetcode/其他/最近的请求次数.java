package leetcode.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/5/6 22:22
 * @role:
 */

class RecentCounter {
    List<Integer> list ;
    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        int index = list.size();
        list.add(t);
        while (index>=0&&list.get(index)+3000>=t){
            index--;
        }
        return list.size()-index-1;
    }
}


public class 最近的请求次数 {
    public static void main(String[] args) {

    }
}
