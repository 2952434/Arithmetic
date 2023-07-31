package until;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2023/4/5 8:35
 * @role:
 */
public class Until {

    public static int[] randomArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = randomArr(4, 8);
        System.out.println(Arrays.toString(ints));

        int[] ints1 = Arrays.copyOf(ints, ints.length);
        System.out.println(Arrays.toString(ints1));
    }
}
