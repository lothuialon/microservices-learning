package com.lothuialon.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "FRAUDCHECK", path = "api/v1/fraudcheck")
public interface fraudClient {
    
    @GetMapping(value="/{userId}")
    fraudDTO isFraud(@PathVariable("userId") Integer userId);

}
