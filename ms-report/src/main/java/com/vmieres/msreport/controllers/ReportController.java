package com.vmieres.msreport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msreport.services.ReportService;

@RestController
@RequestMapping("/report")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    ReportService reportService;
}
