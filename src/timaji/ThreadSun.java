package timaji;

/**
 * @Author: Ljx
 * @Date: 2022/10/24 20:48
 * @role:
 */
public class ThreadSun extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println(i);
        }
    }

}
