package juc.test;

import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author 秦家乐
 * @date 2022/4/5 21:01
 */
public class Demo2 {
    
    public static void main(String[] args) throws Exception {
        
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ArrayList<Callable<Integer>> callableArrayList = Lists.newArrayList(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("1");
                return 1;
            }
        }, new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("2");
                //
                //try {
                //    Thread.sleep(1000);
                //    System.out.println("2");
                //
                //} catch (Exception e) {
                //    e.printStackTrace();
                //}
                
                return 2;
            }
        });
        Integer integer = threadPool.invokeAny(callableArrayList);
        System.out.println(integer);
        
        
    }
    
}
