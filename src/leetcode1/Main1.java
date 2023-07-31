package leetcode1;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Ljx
 * @Date: 2023/6/27 17:02
 * @role:
 */
public class Main1 {
    public void countWeather(){
        String[] cityS = {"漠河","沈阳","北京","广州","昆明"};
        Random random = new Random();
        int[] arr = new int[31];
        for (String city : cityS) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(2);
            }
            int num = 0;
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    num++;
                }else {
                    max = Math.max(num,max);
                    num = 0;
                }
            }
            System.out.println(city+" 的天气为：" + Arrays.toString(arr));
            System.out.println(city+" 最大连续无降水天数：" + max);
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.countWeather();
    }
}
