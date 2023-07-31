package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/5/13 11:05
 * @role:
 */
public class 面试题01_05_一次编辑 {
    public static void main(String[] args) {

    }
    public boolean oneEditAway(String first, String second) {
        // 判断是否相同
        if (first.equals(second)){
            return true;
        }
        int f = first.length();
        int c = second.length();
        // 如果长度差大于1返回false
        if (Math.abs(f-c)>1){
            return false;
        }else if (Math.abs(f-c)==1){
            // 如果长度差等于1
            int j = 0;
            int x = 0;
            // 如果f大于c
            if (f>c){
                for (int i = 0; i < second.length(); i++) {
                    if (second.charAt(i)!=first.charAt(j)){
                        i--;
                        x++;
                    }
                    if (x>1){
                        return false;
                    }
                    j++;
                }
            }else {
                for (int i = 0; i < first.length(); i++) {
                    if (second.charAt(j)!=first.charAt(i)){
                        i--;
                        x++;
                    }
                    if (x>1){
                        return false;
                    }
                    j++;
                }
            }
            return true;
        }else {
            // 如果f等于c
            int j = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i)!=second.charAt(i)){
                    j++;
                }
                if (j>1){
                    return false;
                }
            }
            return true;
        }

    }
}
