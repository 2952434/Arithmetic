package day03;

/**
 * @Author: Ljx
 * @Date: 2022/3/29 21:53
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=40&spm_id_from=pageDriver
 */
public class 题2_最快效率求出乱序数组中第k小的数 {

    public static void main(String[] args) {
        int[] arr = {1,23,143,45,31,2325,4131,15,55,324,233,13,25,43};
        System.out.println(selectK(arr, 0, arr.length-1, 4));
    }

    static int selectK(int[] arr,int p,int r,int k){
        //主元的下标
        int q = partition2(arr, p, r);
        //主元是第几个元素
        int qk = q - p + 1;
        if (qk==k){
            return arr[q];
        }else if (qk>k){
            return selectK(arr,p,q-1,k);
        }else {
            return selectK(arr,q+1,r,k-qk);
        }
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
