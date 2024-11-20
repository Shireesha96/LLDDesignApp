package com.scaler.siri.lldprjoects.ParkingLot.strategies.spotAssignmentStrategy;

import com.scaler.siri.lldprjoects.ParkingLot.models.Gate;
import com.scaler.siri.lldprjoects.ParkingLot.models.ParkingSpot;
import com.scaler.siri.lldprjoects.ParkingLot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(Gate gate, VehicleType vehicleType);
}
