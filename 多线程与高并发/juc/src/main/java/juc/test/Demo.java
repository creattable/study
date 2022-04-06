package juc.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 秦家乐
 * @date 2022/4/5 12:18
 */
public class Demo implements Callable {
    
    public static void main(String[] args) {
    
        Demo demo = new Demo();
        FutureTask futureTask = new FutureTask<>(demo);
        new Thread(futureTask,"有返回值").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    
    
    }
    
    
    @Override
    public Object call() throws Exception {
        System.out.println("test1");
        return 1;
    }
}
