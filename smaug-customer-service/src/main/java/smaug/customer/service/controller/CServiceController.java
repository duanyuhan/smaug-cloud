package smaug.customer.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import smaug.customer.service.controller.rabbit.RabbitMqHandler;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by naonao on 18/7/2.
 */
@RestController
@RequestMapping("/customer")
public class CServiceController {
    @Autowired
    RabbitMqHandler rabbitMqHandler;

    @RequestMapping(method = RequestMethod.GET, path = "/ping")
    @ResponseBody
    public String ping() throws IOException, TimeoutException {
        //rabbitMqHandler.sender();
        return "pong";
    }
}
