package com.vmieres.msvehicle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msvehicle.repositories.BrandRepository;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

}