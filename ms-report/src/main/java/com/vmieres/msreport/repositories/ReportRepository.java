package com.vmieres.msreport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msreport.entities.ReportEntity;

import java.time.YearMonth;
import java.util.ArrayList;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long>{

    // public boolean existsByDate(YearMonth date);
    
    public ReportEntity findByRepairTypeNameAndPeriod(String repairTypeName, YearMonth period);

    public ArrayList<ReportEntity> findAllByPeriod(YearMonth period);

}
