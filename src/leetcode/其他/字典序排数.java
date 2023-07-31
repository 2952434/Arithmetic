package leetcode.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/4/18 17:15
 * @role: https://leetcode-cn.com/problems/lexicographical-numbers/
 */
public class 字典序排数 {

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans=new ArrayList<>();
        addNum(0,n,ans);
        return ans;
    }
    public static void addNum(int k,int n,List<Integer> ans){
        if(k>n){
            return;
        }
        if(k>0){
            ans.add(k);
        }
        k *= 10;
        for(int i=k==0?1:0;i<10;i++){
            addNum(k+i,n,ans);
        }
    }
}