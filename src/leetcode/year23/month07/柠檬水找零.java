package leetcode.year23.month07;

public class 柠檬水找零 {

    public static boolean lemonadeChange(int[] bills) {
        int[] arr = new int[3];

        for (int bill : bills) {
            if (bill == 5) {
                arr[0] += bill;
            } else if (bill == 10) {
                arr[1] += bill;
                if (arr[0] < bill - 5) {
                    return false;
                } else {
                    arr[0] -= 5;
                }
            } else {
                arr[2] += bill;
                if (arr[1] > 0) {
                    arr[1] -= 10;
                    if (arr[0] > 0) {
                        arr[0] -= 5;
                    } else {
                        return false;
                    }
                } else {
                    if (arr[0] < bill - 5) {
                        return false;
                    } else {
                        arr[0] -= 15;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 5, 20, 5, 10, 5, 5}));
    }
}
