package com.vmieres.msvehicle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msvehicle.entities.BrandEntity;
import com.vmieres.msvehicle.repositories.BrandRepository;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public BrandEntity updateBrand(BrandEntity brand) throws Exception{
        if (brandRepository.existsById(brand.getBrandId()))
            return brandRepository.save(brand);
        else
            throw new Exception("Brand not found");
    }

    public int getBonus(Long brandId){
        BrandEntity b = brandRepository.findById(brandId).get();
        return b.getDiscount();
    }

}