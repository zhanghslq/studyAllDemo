package com.zhs.test;

import java.util.concurrent.*;

/**
 * @author: zhs
 * @since: 2020/10/28 15:26
 */
public class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,1000,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.AbortPolicy());

        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        threadPoolExecutor.submit(futureTask);
        System.out.println(futureTask.get());

    }
}
