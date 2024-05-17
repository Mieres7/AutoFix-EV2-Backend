package com.vmieres.msvehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msvehicle.entities.BrandEntity;


@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long>{
}