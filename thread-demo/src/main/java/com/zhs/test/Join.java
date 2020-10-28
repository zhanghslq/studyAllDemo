package com.zhs.test;

public class Join {
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("我是⼦线程，我先睡⼀秒");
                Thread.sleep(1000);
                System.out.println("我是⼦线程，我睡完了⼀秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        // 等这个线程执行完，主线程等待子线程
        thread.join();
        System.out.println("如果不加join⽅法，我会先被打出来，加了就不⼀样了");
    }
}