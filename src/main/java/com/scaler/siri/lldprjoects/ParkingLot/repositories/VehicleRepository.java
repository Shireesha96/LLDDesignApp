package com.scaler.siri.lldprjoects.ParkingLot.repositories;

import com.scaler.siri.lldprjoects.ParkingLot.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber){
        return Optional.empty();
    }

    //Upsert
    public Vehicle save(Vehicle vehicle){
        return null;
    }
}
