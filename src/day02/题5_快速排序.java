package day02;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/3/28 22:10
 * @role:
 */
public class 题5_快速排序 {
    public static void main(String[] args) {
        int[] arr = {1,23,143,45,31,2325,4131,15,55,324,233,13,25,43};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr,int p,int r){
        if (p<r){
//            如果 r-p+1<=8 可使用插入排序
//            int q = partition(arr, p, r);
            int q = partition2(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
    }

//    单向扫描分区
    static int partition(int[] arr,int p, int r){
        int pivot = arr[p];
        int sp = p+1;
        int bigger = r;
        while (sp<=bigger){
            if (arr[sp]<=pivot){
                sp++;
            }else {
                swap(arr,sp,bigger);
                bigger--;
            }
        }
        swap(arr,p,bigger);
        return bigger;
    }

    /**
     * 双向扫描法
     */
    static int partition2(int[] arr, int p, int r){
        //优化 三点中值法
        //中间下标
        int midIndex = p + ((r-p)>>1);
        //中值下标
        int midValueIndex = -1;
        if (arr[p]<=arr[midIndex]&&arr[p]>=arr[r]){
            midValueIndex = p;
        }else if (arr[r] <= arr[midIndex]&&arr[r]>=arr[p]){
            midValueIndex = r;
        }else {
            midValueIndex = midIndex;
        }
        swap(arr,p,midValueIndex);
        int pivot = arr[p];
        int left = p+1;
        int right = r;
        while (left<=right){
            while (left<=right&&arr[left]<=pivot){
                left++;
            }
            while (left<=right&&arr[right]>pivot){
                right--;
            }
            if (left<right){
                swap(arr,left,right);
            }
        }
        swap(arr, p, right);
        return right;
    }
    static void swap(int[] arr,int begin,int end){
        int a = arr[begin];
        arr[begin] = arr[end];
        arr[end] = a;
    }
}
