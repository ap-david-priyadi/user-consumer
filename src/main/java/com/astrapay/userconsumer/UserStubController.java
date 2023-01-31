package com.astrapay.userconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStubController {

    @Autowired
    private UserClient userClient;


    @GetMapping("/users/{id}")
    public UserClientDto getUserById(@PathVariable Long id){
        return userClient.getUserById(id);
    }
}
