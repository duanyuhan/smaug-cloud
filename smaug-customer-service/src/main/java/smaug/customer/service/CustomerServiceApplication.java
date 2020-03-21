package smaug.customer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import smaug.customer.service.controller.designMode.bean.BeanTest;

/**
 * Created by naonao on 18/7/2.
 */
@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext cx = (ConfigurableApplicationContext) SpringApplication.run(CustomerServiceApplication.class, args);
        BeanTest beanTest = (BeanTest) cx.getBean("&beanFactoryTest");
        beanTest.test();
    }
}
