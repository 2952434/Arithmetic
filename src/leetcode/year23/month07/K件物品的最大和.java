package leetcode.year23.month07;

/**
 * @Author: Ljx
 * @Date: 2023/7/5 8:44
 * @role:
 */
public class K件物品的最大和 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ren;
        if (k <= numOnes) {
            return k;
        }else {
            ren = numOnes;
            k -= numOnes;
            if (k <= numZeros){
                return ren;
            }else {
                k -= numZeros;
                ren -= k;
                return ren;
            }
        }
    }

}
