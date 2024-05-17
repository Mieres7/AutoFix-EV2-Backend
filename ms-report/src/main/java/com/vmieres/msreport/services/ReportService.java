package com.vmieres.msreport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msreport.repositories.ReportRepository;

@Service
public class ReportService {
    
    @Autowired
    ReportRepository reportRepository;

}
