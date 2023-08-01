package leetcode.year23.month07;

/**
 * @Author: 李君祥
 * @create: 2023-07-28 14:48
 * @description: 乐团站位
 */
public class 乐团站位 {
    public int orchestraLayout(int num, int xPos, int yPos) {
        int layer = Math.min(getLayer(num, xPos), getLayer(num, yPos));

        int n = num - layer * 2;
        int he = 0;
        for (int i = 0; i < layer; i++) {
            he += (num - i * 2 ) * 4;
        }
        int index = (he % 9 + 1) % 9;
        //右边界
        int right=num-layer;
        //左边界
        int left=layer-1;
        if(xPos==left){
            //在 --- 上
            index+=yPos-left;
        }else if(yPos==right){
            //在   |上
            index+=right-left;
            index+=xPos-left;
        }else if(xPos==right){
            //在 __ 上
            index+=2*(right-left);
            index+=right-yPos;
        }else{
            //在 |  上
            index+=3*(right-left);
            index+=right-xPos;
        }
        return (index%9==0?9:index%9);


    }

    public int getLayer(int num, int n) {
        int[] arr = new int[num];
        int x = 0;
        int l = 0;
        int r = num - 1;
        while (l <= r) {
            arr[l] = x;
            arr[r] = x;
            x++;
            l++;
            r--;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        乐团站位 l = new 乐团站位();
        System.out.println(l.orchestraLayout(6408, 1889, 3386));
    }
}
