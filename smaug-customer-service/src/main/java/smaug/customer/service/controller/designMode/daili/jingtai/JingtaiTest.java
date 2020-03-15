package smaug.customer.service.controller.designMode.daili.jingtai;

public class JingtaiTest {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.save();
    }
}
