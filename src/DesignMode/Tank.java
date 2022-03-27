package DesignMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author zhenghuan
 * @date 2022/2/18
 */
public class Tank implements Movable {

    @Override
    public void move(int i) {
        System.out.println("tank clacla....");
        System.out.println(i);
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        final Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{ Movable.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(final Object proxy, final Method method,
                            final Object[] args)
                            throws Throwable {
                        System.out.println("method " + method.getName() + " start...");
                        final Object o = method.invoke(tank, args);
                        System.out.println("method " + method.getName() + " end...");
                        return o;
                    }
                });
        m.move(11);
    }
}

interface Movable {
    void move(int i);
}
