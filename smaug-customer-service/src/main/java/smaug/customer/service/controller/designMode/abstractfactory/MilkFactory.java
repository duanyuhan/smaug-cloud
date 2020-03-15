package smaug.customer.service.controller.designMode.abstractfactory;

import smaug.customer.service.controller.designMode.factory.MengNiu;
import smaug.customer.service.controller.designMode.factory.Milk;
import smaug.customer.service.controller.designMode.factory.Telunsu;
import smaug.customer.service.controller.designMode.factory.Yili;

public class MilkFactory extends AbstractMilkFactory {

    @Override
    public Milk getTeLunSu() {
        return new Telunsu();
    }

    @Override
    public Milk getYiLi() {
        return new Yili();
    }

    @Override
    public Milk getMengNiu() {
        return new MengNiu();
    }
}
