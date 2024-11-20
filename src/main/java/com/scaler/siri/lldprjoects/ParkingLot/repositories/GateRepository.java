package com.scaler.siri.lldprjoects.ParkingLot.repositories;

import com.scaler.siri.lldprjoects.ParkingLot.models.Gate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gateMap = new HashMap<>(); // better to find based on id instead of list without iteration
    private Long gateId = 0L;

    public Optional<Gate> findGateByID(long Id){
        if(gateMap.containsKey(Id)){
            return Optional.of(gateMap.get(Id));
        }

        return Optional.empty();
    }

    public Gate save(Gate gate){
        if(gate.getId() == 0){
            gateId+=1;
            gate.setId(gateId);
            gateMap.put(gateId, gate);
        }
        else{
            gateMap.put(gate.getId(), gate);
        }

        return gate;
    }
}
