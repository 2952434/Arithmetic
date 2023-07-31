package day04;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/3/31 18:00
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=112
 */
public class 题4_子集生成 {

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(getSubsetsCore(arr, arr.length - 1));

        System.out.println(getSubsets2(arr,arr.length));

        System.out.println(getSubsets(arr,arr.length));
    }


    /**
     * 递归法
     * @param arr
     * @param cur
     * @return
     */
    static Set<Set<Integer>> getSubsetsCore(int[] arr,int cur){
        Set<Set<Integer>> newSet = new HashSet<>();
        if (cur==0){
            Set<Integer> nil = new HashSet<>();
            Set<Integer> first = new HashSet<>();
            first.add(arr[0]);
            newSet.add(nil);
            newSet.add(first);
            return newSet;
        }
        Set<Set<Integer>> oldSet = getSubsetsCore(arr,cur-1);
        for (Set<Integer> set : oldSet) {
            newSet.add(set);
            Set<Integer> clone = (Set<Integer>) ((HashSet) set).clone();
            clone.add(arr[cur]);
            newSet.add(clone);
        }
        return newSet;
    }

    /**
     * 迭代法
     * @param arr
     * @param n
     * @return
     */
    static Set<Set<Integer>> getSubsets2(int[] arr,int n){
        Set<Set<Integer>> res = new HashSet<>();
        //初始化为空集
        res.add(new HashSet<>());
        //从第一个元素开始处理
        for (int i = 0; i < n; i++) {
            Set<Set<Integer>> resNew = new HashSet<>();
//            resNew.addAll(res);
            for (Set<Integer> re : res) {
                resNew.add(re);
                Set<Integer> clone = (Set<Integer>) ((HashSet) re).clone();
                clone.add(arr[i]);
                resNew.add(clone);
            }
            res = resNew;
        }
        return res;
    }

    /**
     * 二进制法
     * @param arr
     * @param n
     * @return
     */
    static List<List<Integer>> getSubsets(int[] arr,int n){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = (int) (Math.pow(2,n)) ; i > 0; i--){
            List<Integer> list = new ArrayList<>();
            for (int j = n-1;j>=0;j--){
//                System.out.println(Integer.toString(i,2));
                if (((i>>j)&1)==1){
                    list.add(arr[j]);
                }
            }
            res.add(list);
        }
        return res;
    }



}
