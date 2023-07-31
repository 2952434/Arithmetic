package niuke;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/11/21 11:40
 * @role:
 */
public class day02 {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> ren = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(num);
        permutation(ren,num,map);
        return ren;
    }
    public void permutation(ArrayList<ArrayList<Integer>> ren,int[] nums,Map<Integer,Integer> map){
        if (map.size() == nums.length){
            Collection<Integer> values = map.values();
            c:for (ArrayList<Integer> list : ren) {
                Iterator<Integer> iterator = values.iterator();
                int i = 0;
                while (iterator.hasNext()){
                    Integer next = iterator.next();
                    if (!next.equals(list.get(i))){
                        continue c;
                    }
                    i++;
                }
                return;
            }
            ArrayList<Integer> list1 = new ArrayList<>(values);
            ren.add(list1);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i)){
                map.put(i,nums[i]);
                permutation(ren, nums, map);
                map.remove(i);
            }
        }
    }
}
