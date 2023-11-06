package com.lothuialon.fraud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lothuialon.clients.fraud.fraudDTO;
import com.lothuialon.fraud.service.Imp.fraudCheckHistoryServiceImp;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@RestController
@RequestMapping(value = "/api/v1/fraudcheck")
public class fraudCheckController {

    private fraudCheckHistoryServiceImp fraudCheckHistoryServiceImp;

    @Autowired
    public fraudCheckController(fraudCheckHistoryServiceImp fraudCheckHistoryServiceImp) {
        this.fraudCheckHistoryServiceImp = fraudCheckHistoryServiceImp;
    }

    
    @GetMapping(value="/{userId}")
    public fraudDTO isFraud(@PathVariable("userId") Integer userId) {
        
        fraudDTO fraudDTO = fraudCheckHistoryServiceImp.userIsFraud(userId);
        log.info("New fraud check - {}", fraudDTO);
        //if(fraudDTO.isFraud()){}
        return fraudDTO;
    }
    

}
