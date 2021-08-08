package sycronizion;

import java.util.concurrent.TimeUnit;

/**
 * @author zacyex
 * @date 2020/11/22 18:14
 */
public class VolitalTest {

    public static void main(String[] args) {
        User user = new User();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + "come in");
            user.numToSix();
            System.out.println(Thread.currentThread().getName() + ":" + "updated num");
        },"A").start();

        while (user.num == 0){

        }
        System.out.println(Thread.currentThread().getName()+":"+"num has bean updated");
    }
}

class User{
    /*volatile*/ int num = 0;
    public void numToSix(){
        this.num = 6;
    }
}
