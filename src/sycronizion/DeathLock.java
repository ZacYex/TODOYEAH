package sycronizion;

import java.util.concurrent.TimeUnit;

/**
 * @author zacyex
 * @date 2020/11/24 13:43
 */
public class DeathLock {

//    private int num = 0;
//
//    public static void main(String[] args) {
//
//        DeathLock deathLock = new DeathLock();
//
//        new Thread(()->{
//            try {
//                deathLock.setNum();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        while(Thread.activeCount() > 0){
//            Thread.yield();
//        }
//
//    }
//
//    public synchronized void setNum() throws InterruptedException {
//        while (num == 0){
//            this.wait();
//        }
//        this.num = 1;
//        this.notifyAll();
//    }
    private Object lock1 = new Object();
    private Object lock2 = new Object();


    public static void main(String[] args) {

        DeathLock deathLock = new DeathLock();

        new Thread(()->{
            try {
                deathLock.thread1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
                deathLock.thread2();
        },"B").start();

    }

    public void thread1() throws InterruptedException {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+":"+"对1加锁!");
            TimeUnit.SECONDS.sleep(1);
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+":"+"对2加锁!");
            }
        }
    }

    public void thread2(){
        synchronized (lock2){
            System.out.println(Thread.currentThread().getName()+":"+"对2加锁!");
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+":"+"对1加锁!");
            }
        }
    }

}
