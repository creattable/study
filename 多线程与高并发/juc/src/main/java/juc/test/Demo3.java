package juc.test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 秦家乐
 * @date 2022/4/5 22:01
 */
public class Demo3 {
    
    public static void main(String[] args) throws Exception {
        int cps = 1;
        int mps = 2;
        int c = 5;
        int size = mps + c;
        
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(cps, mps,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(c), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        
        for (int i = 0; i < size; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("old");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(i);
        }
        
        threadPoolExecutor.execute(() -> {
            try {
                Thread.sleep(100);
                System.out.println("new");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        
        System.out.println("wait");
        
        
    }
    
    
}
