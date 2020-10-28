package com.zhs.test;

import java.util.stream.IntStream;

/**
 * @author: zhs
 * @since: 2020/10/28 15:34
 */
public class Demo {
   /* public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread 当前线程组名字"+Thread.currentThread().getThreadGroup().getName());
            System.out.println("thread 线程名字"+Thread.currentThread().getName());
        });
        thread.start();
        System.out.println("执行main方法线程名字"+Thread.currentThread().getName());
        Thread a = new Thread();
        System.out.println("我是默认线程优先级："+a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("我是设置过的线程优先级："+b.getPriority());
    }
*/
    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执⾏的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }
    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }
}
