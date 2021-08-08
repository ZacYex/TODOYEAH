package sycronizion;

/**
 * @author zacyex
 * @date 2020/11/11 20:05
 */
public class SycronizeMain {
    public static void main(String args[]){

        SycronizeTest soutStr = new SycronizeTest();

        new Thread(()->{
            for(int i=0; i<10; i++){
                try {
                    soutStr.numSout();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for(int i=0; i<10; i++){
                try {
                    soutStr.numSout();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for(int i=0; i<10; i++){
                try {
                    soutStr.strSout();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for(int i=0; i<10; i++){
                try {
                    soutStr.strSout();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}
