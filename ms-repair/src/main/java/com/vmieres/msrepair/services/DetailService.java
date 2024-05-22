package com.vmieres.msrepair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msrepair.repositories.DetailRepository;

@Service
public class DetailService {
    @Autowired
    DetailRepository detailRepository;
}
