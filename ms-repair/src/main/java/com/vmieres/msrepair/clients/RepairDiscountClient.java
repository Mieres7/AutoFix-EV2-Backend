package com.vmieres.msrepair.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name  = "ms-repairlist") 
public interface RepairDiscountClient {

    @GetMapping("/repair-discount/get-discount")
    public float getDiscount(int repairs_, String vehicleType);


}