package com.vmieres.msreport.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name  = "ms-repairlist") 
public interface RepairListFeingClient {

    @GetMapping("/repair-list/get-all-names")
    List<String> getRepairTypeNames();

}
