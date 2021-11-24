package proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zacyex
 * @date 2020/11/3 22:02
 */
public class ZacProxyFactory {

    public Object getInhancerInstancec(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName() == "sayHello"){
                    System.out.println("Long Time No Say!");
                    method.invoke(obj);
                }
                return null;
            }
        });
    }

}
