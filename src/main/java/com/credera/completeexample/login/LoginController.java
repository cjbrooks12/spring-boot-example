package com.credera.completeexample.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    /**
     * Run a real query to find a user by name
     */
    @RequestMapping("/login/{name}")
    public String find(@PathVariable String name) {
        return service.getUserByName(name, false);
    }

    /**
     * Run a mock query to find a user by name
     */
    @RequestMapping("/login/mock/{name}")
    public String findInMock(@PathVariable String name) {
        return service.getUserByName(name, true);
    }
}
