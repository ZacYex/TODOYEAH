package proxyTest;

/**
 * @author zacyex
 * @date 2020/11/3 22:02
 */
public class Main {
    public static void main(String[] args) {
//        ZacProxyFactory zacProxyFactory = new ZacProxyFactory();
//
//        User user = new User();
//        System.out.println(user);
//        UserInterface userInterface = (UserInterface) zacProxyFactory.getInhancerInstancec(user);
//        userInterface.sayHello();
//        System.out.println(userInterface);

        User user = new User();
        change(user);
        System.out.println(user);

    }

    public static void change(User user){
        user = new User();
        System.out.println(user);
    }
}
