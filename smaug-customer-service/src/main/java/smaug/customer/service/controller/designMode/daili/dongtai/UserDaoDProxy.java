package smaug.customer.service.controller.designMode.daili.dongtai;

import smaug.customer.service.controller.designMode.daili.jingtai.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoDProxy {

    public IUserDao target;

    public UserDaoDProxy(IUserDao target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事物");
                Object returnValue = method.invoke( target,args);
                System.out.println("结束事物");
                return returnValue;
            }
        });
    }
}
