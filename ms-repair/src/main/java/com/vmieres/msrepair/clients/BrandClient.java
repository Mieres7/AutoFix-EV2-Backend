package com.vmieres.msrepair.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name  = "ms-vehicle") 
public interface BrandClient {

    @GetMapping("/brand/get-bonus")
    public int getBonus(Long brandId);


}