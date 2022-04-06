package juc.threadbasic;

/**
 * @author 秦家乐
 * @date 2022/3/28 21:04
 */
public class VolatileFlag {
    
    private static volatile boolean running = true;
    
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            long i=0;
            while (running){
                i++;
            }
            System.out.println("end and i="+i);
        });
        
        t.start();
    
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        running=false;
    
    }
    
}
