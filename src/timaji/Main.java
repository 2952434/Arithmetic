package timaji;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;

/**
 * @Author: Ljx
 * @Date: 2022/9/2 20:08
 * @role:
 */
public class Main {


    public static void main(String[] args) {
//        ThreadSun threadSun = new ThreadSun();
//        ThreadSun1 threadSun1 = new ThreadSun1();
//        threadSun.start();
//        threadSun1.start();

//        RunnableImpl runnable = new RunnableImpl();
//        Thread thread = new Thread(runnable);
//        thread.start();

//        CallableImpl callable = new CallableImpl();
////        FutureTask futureTask = new FutureTask<>(callable);
////        Thread thread = new Thread(futureTask);
////        thread.start();

        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        System.out.println(deque.pollFirst());


    }

}

