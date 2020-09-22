package juc.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: zhs
 * @since: 2020/9/21 14:51
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);

        semaphore.acquire();
        semaphore.acquire();



        semaphore.release();





    }
}
