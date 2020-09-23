package juc.lock;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    Semaphore semaphoreFoo = new Semaphore(1);
    Semaphore semaphoreBar = new Semaphore(0);
    public FooBar(int n)  {

        this.n = n;
    }
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphoreFoo.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            semaphoreBar.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphoreBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        	semaphoreFoo.release();
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            try {
                new FooBar(4).foo(()->{});
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}