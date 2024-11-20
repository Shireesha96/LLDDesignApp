package com.scaler.siri.lldprjoects.ParkingLot.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<VehicleType> supportedVehicleTypes;
    private ParkingLotStatus parkingLotStatus;

    private ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;
    private FeeCalculationStrategyType feeCalculationStrategyType;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public ParkingSpotAssignmentStrategy getParkingSpotAssignmentStrategy() {
        return parkingSpotAssignmentStrategy;
    }

    public void setParkingSpotAssignmentStrategy(ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy) {
        this.parkingSpotAssignmentStrategy = parkingSpotAssignmentStrategy;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }


}
