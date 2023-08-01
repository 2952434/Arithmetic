package leetcode.year23.month07;

public class 宝石与石头 {

    public int numJewelsInStones(String jewels, String stones) {
        // 把 jewels 转换成字符集合 mask
        long mask = 0;
        for (char c : jewels.toCharArray()) {
            mask |= 1L << (c & 63);
        }
        // 统计有多少 stones[i] 在集合 mask 中
        int ans = 0;
        for (char c : stones.toCharArray()) {
            ans += mask >> (c & 63) & 1;
        }
        return ans;
    }

}
