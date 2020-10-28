package com.zhs.test;

/**
 * @author: zhs
 * @since: 2020/10/28 15:41
 */
public class GroupTest {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        // 线程组的优先级
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup,"thread");
        //所以，如果某个线程优先级⼤于线程所在线程组的最⼤优先级，那么该线程的优先
        //级将会失效，取⽽代之的是线程组的最⼤优先级。
        thread.setPriority(3);
        System.out.println("我是线程组的优先级"+threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级"+thread.getPriority());


        Thread[] threads = new Thread[threadGroup.activeCount()];
        ThreadGroup threadGroup1 = new ThreadGroup("");
        threadGroup1.enumerate(threads);
    }
}
