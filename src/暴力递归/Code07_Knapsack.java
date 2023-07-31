package 暴力递归;

/**
 * @Author: Ljx
 * @Date: 2023/4/18 10:27
 * @role: 背包装最大价值
 */
public class Code07_Knapsack {

    public  int process1(int[] weights,int[] values,int i,int alreadyWeight,int bag) {
        if (alreadyWeight > bag){
            return 0;
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(process1(weights,values,i + 1, alreadyWeight,bag),
                values[i] + process1(weights,values,i+1,alreadyWeight+weights[i],bag));

    }
}
