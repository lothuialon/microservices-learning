package com.lothuialon.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lothuialon.user.dto.userDTO;
import com.lothuialon.user.service.Imp.userServiceImp;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Log4j2
@RestController
@RequestMapping(path = "/api/v1/users")
public class userController {
    
    private userServiceImp userService;

    @Autowired
    public userController(userServiceImp userServiceImp) {
        this.userService = userServiceImp;
    }


    @PostMapping(value="")
    public void registerUser(@RequestBody userDTO userDTO) {
        log.info("new user register: {}", userDTO);
        userService.registerUser(userDTO);
    }
    

}
