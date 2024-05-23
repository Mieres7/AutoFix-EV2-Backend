package com.vmieres.msrepair.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name  = "ms-repairlist") 
public interface AgeChargeClient {

    @GetMapping("/km-charge/get-charge")
    public float getDiscount(String manufactureYear, String vehicleType);


}