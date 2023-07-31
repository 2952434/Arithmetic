package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/11/20 10:02
 * @role:
 */
public class day01 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        list.add(2);
        lists.add(list);
        System.out.println(lists.get(0));
        System.out.println(lists.get(1));
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        recursion(res,num,0);
        return res;
    }
    public void recursion(ArrayList<ArrayList<Integer>> res,int[] arr,int index){
        if (index==arr.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : arr) {
                list.add(i);
            }
            res.add(list);
        }else {
            for (int i = index; i < arr.length; i++) {
                swap(arr,index,i);
                recursion(res,arr,index+1);
                swap(arr,index,i);
            }
        }
    }
}
