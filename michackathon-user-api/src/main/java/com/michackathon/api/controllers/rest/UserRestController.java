package com.michackathon.api.controllers.rest;


import com.michackathon.dto.commons.ValueObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Tomasz Kucharzyk
 */

@RestController
@RequestMapping("/user/")
public class UserRestController {

    @RequestMapping("/title")
    public ValueObject getTitle(Principal user) {
        return new ValueObject("API SERVER IS ALIVE" + (user == null ? "" : " " + user.getName()));
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
