package com.vmieres.msreport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msreport.entities.ReportEntity;

import java.util.ArrayList;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long>{

    public boolean existsByMonthAndYear(String month, String Year);
    
    public ReportEntity findByRepairTypeNameAndMonthAndYear(String repairTypeName, String month, String year);

    public ArrayList<ReportEntity> findAllByMonthAndYear(String month, String year);

    public ReportEntity findByMonthAndYear(String month, String year);

}
