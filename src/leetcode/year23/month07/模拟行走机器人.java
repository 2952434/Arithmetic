package leetcode.year23.month07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 模拟行走机器人 {

    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        for (int[] obstacle : obstacles) {
            Set<Integer> orDefault = map.getOrDefault(obstacle[0], new HashSet<>());
            orDefault.add(obstacle[1]);
            map.put(obstacle[0], orDefault);

            Set<Integer> orDefault1 = map1.getOrDefault(obstacle[1], new HashSet<>());
            orDefault1.add(obstacle[0]);
            map1.put(obstacle[1], orDefault1);
        }
        int x = 0;
        int y = 0;
        int direction = 0;
        int max = 0;
        c:
        for (int command : commands) {
            Set<Integer> setY = map.getOrDefault(x, new HashSet<>());
            Set<Integer> setX = map1.getOrDefault(y, new HashSet<>());
            if (command > 0) {
                if (direction == 0) {
                    for (int j = 1; j <= command; j++) {
                        y++;
                        if (setY.contains(y)) {
                            y--;
                            max = Math.max(max, x * x + y * y);
                            continue c;
                        }
                    }
                } else if (direction == 1) {
                    for (int j = 1; j <= command; j++) {
                        x--;
                        if (setX.contains(x)) {
                            x++;
                            max = Math.max(max, x * x + y * y);
                            continue c;
                        }
                    }
                } else if (direction == 2) {
                    for (int j = 1; j <= command; j++) {
                        y--;
                        if (setY.contains(y)) {
                            y++;
                            max = Math.max(max, x * x + y * y);
                            continue c;
                        }
                    }
                } else {
                    for (int j = 1; j <= command; j++) {
                        x++;
                        if (setX.contains(x)) {
                            x--;
                            max = Math.max(max, x * x + y * y);
                            continue c;
                        }
                    }
                }
                max = Math.max(max, x * x + y * y);
            } else {
                if (command == -2) {
                    direction = (direction + 1) % 4;
                } else {
                    if (direction == 0) {
                        direction = 3;
                    } else {
                        direction--;
                    }
                }
            }
        }
        return max;
    }
}
