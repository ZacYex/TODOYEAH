package ReferenceTest;

import java.lang.ref.Reference;
import java.util.Arrays;

/**
 * @author zacyex
 * @date 2020/11/2 20:50
 */
public class SoftReference {

    private static class SoftRefTest {

        private Byte[] heapMax;

        public SoftRefTest(Byte[] heapMax) {
            this.heapMax = heapMax;
            this.heapMax = null;
        }

        @Override
        public String toString() {
            return "SoftRefTest";
        }
    }


    public static void main(String[] args) {

        Byte[] heapMax = new Byte[1024 * 1024];
        heapMax = null;

        Reference<Object> softReference = new java.lang.ref.SoftReference<Object>(new SoftRefTest(heapMax));

        System.out.println(softReference.get());

        Byte[] testByte = new Byte[1024 * 1600];

        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(softReference.get());
    }

}
