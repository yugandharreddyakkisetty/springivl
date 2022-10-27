package com.bits.m2.assetmaster.dao;

import com.bits.m2.assetmaster.dao.entity.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface TransporterRepo extends JpaRepository<Transporter,Long>,TransporterRepoExtend , JpaSpecificationExecutor<Transporter> {
    @Query("select t from Transporter t where t.code = ?1")
    Optional<Transporter> findByCode(String code);

}
