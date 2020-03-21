package smaug.customer.service.controller.designMode.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("beanFactoryTest")
public class BeanFactoryTest implements FactoryBean<BeanTest> {
    @Override
    public BeanTest getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
