package smaug.customer.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by naonao on 18/7/2.
 */
@RestController
@RequestMapping("/customer")
public class CServiceController {
    @RequestMapping(method = RequestMethod.GET, path = "/ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }
}
