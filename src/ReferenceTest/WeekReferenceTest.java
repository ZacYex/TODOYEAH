package ReferenceTest;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author zacyex
 * @date 2020/11/2 21:17
 */
public class WeekReferenceTest {

    private static class WeekRefTest {
        @Override
        public String toString() {
            return "SoftRefTest";
        }
    }


    public static void main(String[] args) {

        Reference<Object> weekReference = new WeakReference<>(new WeekRefTest());

        System.out.println(weekReference.get());

        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(weekReference.get());
    }
}

