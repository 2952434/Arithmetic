package leetcode.year23.month07;

public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return String.valueOf(add(num2, num1));
        } else {
            return String.valueOf(add(num1, num2));
        }
    }

    public StringBuilder add(String maxNum, String minNum) {
        int minNumLength = minNum.length() - 1;
        int maxNumLength = maxNum.length() - 1;
        int x = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (minNumLength >= 0) {
            int i = minNum.charAt(minNumLength) - '0';
            int a = maxNum.charAt(maxNumLength) - '0';
            int num = i + a + x;
            if (x > 0) {
                x--;
            }
            if (num / 10 != 0) {
                x++;
                num %= 10;
            }
            stringBuilder.append(num);
            minNumLength--;
            maxNumLength--;
        }
        for (int numLength = maxNumLength; numLength >= 0; numLength--) {
            int i = maxNum.charAt(numLength) - '0';
            if (maxNumLength == numLength || x > 0) {
                i += x;
                if (i != 10) {
                    x--;
                }else {
                    i %= 10;
                }
            }
            stringBuilder.append(i);
        }
        if (x == 1) {
            int c = stringBuilder.charAt(stringBuilder.length() - 1) - '0';
            if (c != 9) {

            }
            stringBuilder.append(1);
        }
        return stringBuilder.reverse();
    }

    public static void main(String[] args) {
        字符串相加 l = new 字符串相加();
        System.out.println(l.addStrings("9", "99"));
    }
}
