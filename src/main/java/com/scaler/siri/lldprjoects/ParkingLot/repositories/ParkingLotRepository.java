package com.scaler.siri.lldprjoects.ParkingLot.repositories;

import com.scaler.siri.lldprjoects.ParkingLot.models.Gate;
import com.scaler.siri.lldprjoects.ParkingLot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private Map<Long,ParkingLot> parkingLotMap = new HashMap<>();
    private Long parkingLotId = 0L;

    private GateRepository gateRepository;

    public ParkingLotRepository(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Optional<ParkingLot> findByGateId(long gateID) {
        Optional<Gate> gate = gateRepository.findGateByID(gateID);
//        if (gate.isPresent()) {
//            ParkingLot parkingLot = gate.get().
      //  }

        return Optional.empty();
    }
}
