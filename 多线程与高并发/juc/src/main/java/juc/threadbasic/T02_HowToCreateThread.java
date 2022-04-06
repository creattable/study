package juc.threadbasic;

/**
 * @author 秦家乐
 * @date 2022/3/27 22:23
 */
public class T02_HowToCreateThread {
    
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }
    
    public static void main(String[] args) {
    
    }
    
}
