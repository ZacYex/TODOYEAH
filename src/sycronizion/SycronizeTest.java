package sycronizion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zacyex
 * @date 2020/11/11 19:58
 */
public class SycronizeTest {

    private int num = 0;

    private final Lock lock= new ReentrantLock();

    private final Condition condition = lock.newCondition();

//    public synchronized void numSout() throws InterruptedException {
//
//        while (num != 0) this.wait();
//
//        this.num++;
//        System.out.println(Thread.currentThread().getName() + " 123");
//        this.notifyAll();
//    }
//
//    public synchronized void strSout() throws InterruptedException {
//
//        while (num == 0) this.wait();
//
//        this.num--;
//        System.out.println(Thread.currentThread().getName() + " abc");
//        this.notifyAll();
//    }

    public void numSout() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) condition.await();

            this.num++;
            System.out.println(Thread.currentThread().getName() + " 123");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void strSout() throws InterruptedException {
        lock.lock();
        try {
            while (num == 0) condition.await();

            this.num--;
            System.out.println(Thread.currentThread().getName() + " abc");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
