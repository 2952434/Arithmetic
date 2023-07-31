package day03;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/3/29 18:46
 * @role:
 */
public class 题1_归并排序 {

    static int[] arr = {1,23,143,45,31,2325,4131,15,55,324,233,13,25,43};
    public static void main(String[] args) {
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int p,int r){
        if (p<r){
            int mid = p + ((r-p)>>1);
            mergeSort(arr,p,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,p,mid,r);
        }
    }
    static int[] helper = Arrays.copyOf(arr,arr.length);
    static void merge(int[] arr,int p,int mid,int r){
        helper = Arrays.copyOf(arr,arr.length);
        int left = p;
        int right = mid + 1;
        int current = p;
        while (left<=mid&&right<=r){
            if (helper[left] <= helper[right]){
                arr[current] = helper[left];
                current++;
                left++;
            }else {
                arr[current] = helper[right];
                current++;
                right++;
            }
        }
        while (left<=mid){
            arr[current] = helper[left];
            current++;
            left++;
        }
    }
}
