package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/6/21 18:21
 * @role:
 */
public class IP地址无效化 {
    public static void main(String[] args) {

    }
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
