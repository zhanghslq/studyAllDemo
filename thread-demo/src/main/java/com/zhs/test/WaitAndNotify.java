package com.zhs.test;

/**
 * @author: zhs
 * @since: 2020/10/28 16:30
 */
public class WaitAndNotify {
    private static Object lock = new Object();

    static class ThreadA implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadA :"+i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        // 唤醒等待锁的
                        lock.notify();
                        // 自己释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
