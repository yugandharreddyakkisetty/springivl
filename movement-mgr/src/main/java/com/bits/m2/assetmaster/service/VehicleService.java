package com.bits.m2.assetmaster.service;

import com.bits.m2.assetmaster.dao.entity.Vehicle;
import com.bits.m2.assetmaster.sdo.VehicleSdo;
import com.bits.m2.common.RapidGenericException;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> listOfVehicles();
    public Vehicle saveVehicle(VehicleSdo vehicleSdo) throws RapidGenericException;
    public Vehicle vehicleById(Long id) throws RapidGenericException;
}
