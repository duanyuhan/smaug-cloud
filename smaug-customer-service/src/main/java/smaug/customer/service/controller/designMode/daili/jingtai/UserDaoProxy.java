package smaug.customer.service.controller.designMode.daili.jingtai;

public class UserDaoProxy implements IUserDao {
    public IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事物");
        target.save();
        System.out.println("结束事物");
    }
}
