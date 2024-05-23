package com.vmieres.msrepair.clients;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name  = "ms-repairlist") 
public interface RepairListFeingClient {

    @GetMapping("/repair-list/get-type-cost")
    public int getTypeCostValue(String repairName, String vehicleType);

}