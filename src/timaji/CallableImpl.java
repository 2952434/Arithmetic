package timaji;

import java.util.concurrent.Callable;

/**
 * @Author: Ljx
 * @Date: 2022/10/24 20:57
 * @role:
 */
public class CallableImpl implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 5000; i++) {
            System.out.println(i);
        }
        return null;
    }
}
