package com.bits.m2.assetmaster.dao;

import com.bits.m2.assetmaster.dao.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
}
