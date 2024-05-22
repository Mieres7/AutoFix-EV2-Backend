package com.vmieres.msrepair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msrepair.services.DetailService;

@RestController
@RequestMapping("/detail")
@CrossOrigin("*")
public class DetailController {
    @Autowired
    DetailService detailService;
}

