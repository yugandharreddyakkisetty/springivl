package com.bits.m2.assetmaster.util;

import com.bits.m2.assetmaster.dao.entity.Vehicle;
import com.bits.m2.assetmaster.sdo.VehicleSdo;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleConverter {
    public static VehicleSdo convertToVehicleSdo (Vehicle vehicle) {
        VehicleSdo vehicleSdo = new VehicleSdo();
        vehicleSdo.setVehicleId(vehicle.getId());
        vehicleSdo.setVehicleNumber(vehicle.getVehicleNumber());
        vehicleSdo.setDisplayName(vehicle.getDisplayName());
        if(vehicle.getTransporter() != null) vehicleSdo.setTransporterId(vehicle.getTransporter().getId());
        return vehicleSdo;
    }
    public static List<VehicleSdo> convertToVehicleSdo(List<Vehicle> vehiclesList) {
        return vehiclesList.stream().map(v->convertToVehicleSdo(v)).collect(Collectors.toList());
    }
}
