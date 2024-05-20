package com.vmieres.msreport.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "ms-repairlist",
            path = "/repairlist", // this could change
            configuration = {FeignClientConfiguration.class}) 
public interface RepairListFeingClient {

    @GetMapping("/getRepairTypeNames")
    List<String> getRepairTypeNames();

}
