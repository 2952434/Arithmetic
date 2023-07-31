package day02;

/**
 * @Author: Ljx
 * @Date: 2022/3/28 18:13
 * @role:
 */

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.
 *
 */
public class 题2_旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3};
        System.out.println(min(arr));
    }

    static int min(int[] arr){
        int begin = 0;
        int end = arr.length-1;
        if (arr[begin]<arr[end]){
            return arr[begin];
        }
        while (begin+1<end){
            int mid = begin+((end-begin)>>1);
            if (arr[mid]>=arr[begin]){
                begin = mid;
            }else {
                end = mid;
            }
        }
        return arr[end];
    }
}
