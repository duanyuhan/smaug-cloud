package smaug.customer.service.controller.designMode.factory;

public class MilkFactory {
    public static Milk getMilk(String name) {
        if (name.equals("特仑苏")){
            return new Telunsu();
        } else if (name.equals("伊利")) {
            return new Yili();
        }
        return null;
    }
}
