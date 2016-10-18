package com.michackathon.api.controllers.rest;


import com.michackathon.dto.commons.ValueObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

/**
 * Created by Tomcy John
 */

@RestController
@RequestMapping("/user/")
public class UserRestController {

    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

    @RequestMapping("/title")
    @HystrixCommand(fallbackMethod = "defaultUserTitle")
    public ValueObject getTitle(Principal user) {
        log.info("Inside getTitle method..");
        return new ValueObject("API SERVER IS ALIVE" + (user == null ? "" : " " + user.getName()));
    }

    public ValueObject defaultUserTitle(Principal user) {
        return new ValueObject("Default Title - Fallback method execution");
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
