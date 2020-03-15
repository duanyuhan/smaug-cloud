package smaug.customer.service.controller.designMode.daili.dongtai;

import smaug.customer.service.controller.designMode.daili.jingtai.IUserDao;
import smaug.customer.service.controller.designMode.daili.jingtai.UserDao;

public class ProxyTest {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        IUserDao proxy = (IUserDao) new UserDaoDProxy(target).getProxyInstance();

        proxy.save();
    }
}
