package day01;

/**
 * @Author: Ljx
 * @Date: 2022/3/27 10:46
 * @role:
 */

/**
 * 给定一个介于0和1之间的实数，（如0.625)，类型为double,打印它的二进制表示（0.101,
 * 因为小数点后的二进制分别表示0.5,0.25.0.125......) 。
 * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”
 */
public class 题5_2进制小数 {

    public static void main(String[] args) {
        double num = 0.625;
        StringBuilder sb = new StringBuilder("0.");
        while (num>0){
            double r = num*2;
            if (r>=1){
                sb.append("1");
                num = r - 1;
            }else {
                sb.append("0");
                num = r;
            }
            if (sb.length()>34){
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sb);
    }
}
