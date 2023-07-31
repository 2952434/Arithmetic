package leetcode.其他;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ljx
 * @Date: 2022/6/4 19:34
 * @role:
 */
public class 独特的电子邮件地址 {
    public static void main(String[] args) {
        String email = "test.email+alex@leetcode.com";
        StringBuilder stringBuilder = new StringBuilder();
            int indexOf = email.indexOf("@");
            String substring = email.substring(0, indexOf);
            if (email.indexOf("+")>0){
                substring = substring.substring(0, email.indexOf("+"));
            }
            String[] split = substring.split("\\.");
            for (String s : split) {
                stringBuilder.append(s);
            }
            stringBuilder.append(email.substring(indexOf));
        System.out.println(stringBuilder.toString());
    }
    public static int numUniqueEmails(String[] emails) {
        Set<String> strings = new HashSet<>();
        for (String email : emails) {
            StringBuilder stringBuilder = new StringBuilder();
            int indexOf = email.indexOf("@");
            String substring = email.substring(0, indexOf);
            if (email.indexOf("+")>0&&email.indexOf("+")<indexOf){
                substring = substring.substring(0, email.indexOf("+"));
            }
            String[] split = substring.split("\\.");
            for (String s : split) {
                stringBuilder.append(s);
            }
            stringBuilder.append(email.substring(indexOf));
            strings.add(stringBuilder.toString());
        }
        return strings.size();
    }
}
