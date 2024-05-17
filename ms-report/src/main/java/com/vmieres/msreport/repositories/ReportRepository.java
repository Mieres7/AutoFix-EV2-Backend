package com.vmieres.msreport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msreport.entities.ReportEntity;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long>{
}
