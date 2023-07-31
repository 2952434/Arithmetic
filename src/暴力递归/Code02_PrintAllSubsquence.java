package 暴力递归;

/**
 * @Author: Ljx
 * @Date: 2023/4/18 9:27
 * @role: 打印全排列
 */
public class Code02_PrintAllSubsquence {

    public static void printAllSubsquence(String str){
        char[] chs = str.toCharArray();
        process(chs,0);
    }

    private static void process(char[] str, int i) {
        if (i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process(str,i+1);
        char tmp = str[i];
        str[i] = 0;
        process(str, i + 1);
        str[i] = tmp;
    }

    public static void main(String[] args) {
        printAllSubsquence("abc");
    }
}
