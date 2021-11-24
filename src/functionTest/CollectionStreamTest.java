package functionTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author zacyex
 * @date 2020/11/15 21:06
 */
public class CollectionStreamTest {

    public static void main(String[] args) {
        List<User> lists = new ArrayList<>();

        lists.add(new User(1,"a","man"));
        lists.add(new User(2,"b","man"));
        lists.add(new User(3,"c","man"));
        lists.add(new User(4,"d","man"));
        lists.add(new User(5,"e","woman"));
        lists.add(new User(6,"f","woman"));

        List<User> lists2 = lists.stream().filter(u -> u.getId() > 3)
                      .filter(u -> u.getId() % 2 == 0)
                      .map(u -> new User(u.getId(),u.getName().toUpperCase(),u.getSex()))
                      .limit(1)
                      .collect(Collectors.toList());
        System.out.println(lists2);
    }
}
