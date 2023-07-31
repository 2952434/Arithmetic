package leetcodecompetition;

/**
 * @Author: Ljx
 * @Date: 2023/5/14 10:49
 * @role:
 */
public class 相邻值的按位异或 {

    public boolean doesValidArrayExist(int[] derived) {
        for (int i = 0; i < 1; i++) {
            int before = i;
            for (int j = 0; j < derived.length; j++) {
                int value = derived[j];
                before = before ^ value;
            }
            if (before == i) {
                return true;
            }
        }
        return false;
    }
}
