package com.scaler.siri.lldprjoects.ParkingLot.factories;

import com.scaler.siri.lldprjoects.ParkingLot.models.ParkingSpotAssignmentStrategy;
import com.scaler.siri.lldprjoects.ParkingLot.strategies.spotAssignmentStrategy.NearestSpotAssignmentStrategy;
import com.scaler.siri.lldprjoects.ParkingLot.strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import com.scaler.siri.lldprjoects.ParkingLot.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;
import com.scaler.siri.lldprjoects.ParkingLot.strategies.spotAssignmentStrategy.VIPSpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getStrategy(ParkingSpotAssignmentStrategy strategy) {
        if(strategy.equals(ParkingSpotAssignmentStrategy.NEAREST)){
            return new NearestSpotAssignmentStrategy();
        }
        else if(strategy.equals(ParkingSpotAssignmentStrategy.RANDOM)){
            return new RandomSpotAssignmentStrategy();
        }
        else if(strategy.equals(ParkingSpotAssignmentStrategy.VIP)){
            return new VIPSpotAssignmentStrategy();
        }
        else{
            return  null;
        }
    }
}
