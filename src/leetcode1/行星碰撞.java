package leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/7/13 10:29
 * @role:
 */
public class 行星碰撞 {
    public static void main(String[] args) {
        asteroidCollision(new int[]{-2,-2,1,-2});
    }
    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        c:for (int asteroid : asteroids) {
            if (asteroid>0){
                list.add(asteroid);
            }else {
                if (list.isEmpty()||list.get(list.size()-1)<0){
                    list.add(asteroid);
                    continue;
                }
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (list.get(i)>Math.abs(asteroid)){
                        continue c;
                    }else if (list.get(i)==Math.abs(asteroid)){
                        list.remove(i);
                        continue c;
                    }else {
                        if (list.get(i)<0){
                            list.add(asteroid);
                            continue c;
                        }
                        list.remove(i);
                    }
                }
                if (list.isEmpty()){
                    list.add(asteroid);
                }
            }
        }
        int[] arr =new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
