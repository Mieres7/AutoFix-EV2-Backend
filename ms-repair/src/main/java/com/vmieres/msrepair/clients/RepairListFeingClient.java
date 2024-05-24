package com.vmieres.msrepair.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name  = "ms-repairlist") 
public interface RepairListFeingClient {

    @GetMapping("/repair-list/get-type-cost")
    int getTypeCostValue(@RequestParam("repairName") String repairName,@RequestParam("motorType") String motorType);

    @GetMapping("/repair-discount/get-discount")
    float getDiscountRepairs(@RequestParam("repairs_") int repairs_,@RequestParam("motorType") String motorType);

    @GetMapping("/age-charge/get-charge")
    float getDiscountAge(@RequestParam("manufactureYear") String manufactureYear,@RequestParam("vehicleType") String vehicleType);

    @GetMapping("/km-charge/get-charge")
    float getDiscountKM(@RequestParam("km") int km, @RequestParam("vehicleType") String vehicleType);




}