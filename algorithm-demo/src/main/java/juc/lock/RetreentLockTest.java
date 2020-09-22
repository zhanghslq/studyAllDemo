package juc.lock;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhs
 * @since: 2020/9/21 9:01
 */
public class RetreentLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("");
        } finally {
            lock.unlock();
        }
    }



}
