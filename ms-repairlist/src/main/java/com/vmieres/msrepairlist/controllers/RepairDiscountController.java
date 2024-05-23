package com.vmieres.msrepairlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msrepairlist.services.RepairDiscountService;

@RestController
@RequestMapping("/repair-discount")
public class RepairDiscountController {

    @Autowired
    RepairDiscountService repairDiscountService;

    @GetMapping("/get-discount")
    public ResponseEntity<Float> getDiscount(@RequestParam int repairs_,@RequestParam String motorType){
        float discount  = repairDiscountService.getDiscount(repairs_, motorType);
        return ResponseEntity.ok(discount);
    }


}
