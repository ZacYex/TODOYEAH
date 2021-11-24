package stringTest;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author zacyex
 * @date 2020/10/22 19:55
 */
public class StringLearn {

    public String s;


    public StringLearn(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
//        String b = "a" + "b";
        StringLearn a = new StringLearn("12");
        StringLearn c = a;
        c.s = "13";
    }
}

