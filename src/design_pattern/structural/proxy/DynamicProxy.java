package design_pattern.structural.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String[] args) {

        reflectionProxy();
        //cglibProxy();

    }

    private static void reflectionProxy() {
        GateService gateService = (GateService) Proxy.newProxyInstance(GateService.class.getClassLoader(), new Class[]{GateService.class}, new InvocationHandler() {
            final GateService gateService = new DefaultGateService();

            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                System.out.println("dynamic servlet.proxy start");
                Object invoke = method.invoke(gateService, args);
                System.out.println("dynamic servlet.proxy end");
                return invoke;
            }
        });

        gateService.openGate();
    }


    private static void cglibProxy(){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DefaultGateService.class);


        enhancer.setCallback(new net.sf.cglib.proxy.InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

                DefaultGateService gateService = new DefaultGateService();
                System.out.println("cglib servlet.proxy start");
                Object invoke = method.invoke(gateService);
                System.out.println("cglib servlet.proxy end");

                return invoke;
            }
        });

        DefaultGateService gateService = (DefaultGateService) enhancer.create();
        gateService.openGate();


    }

}
