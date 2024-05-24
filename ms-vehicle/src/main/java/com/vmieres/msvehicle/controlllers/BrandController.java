package com.vmieres.msvehicle.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msvehicle.services.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/get-bonus")
    public ResponseEntity<Integer> getBonus(@RequestParam Long brandId){
        int discount = brandService.getBonus(brandId);
        return ResponseEntity.ok(discount);
    }
    

}