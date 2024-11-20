package com.scaler.siri.lldprjoects.ParkingLot.services;

import com.scaler.siri.lldprjoects.ParkingLot.exceptions.InvalidGateException;
import com.scaler.siri.lldprjoects.ParkingLot.factories.SpotAssignmentStrategyFactory;
import com.scaler.siri.lldprjoects.ParkingLot.models.*;
import com.scaler.siri.lldprjoects.ParkingLot.repositories.GateRepository;
import com.scaler.siri.lldprjoects.ParkingLot.repositories.ParkingLotRepository;
import com.scaler.siri.lldprjoects.ParkingLot.repositories.TicketRepository;
import com.scaler.siri.lldprjoects.ParkingLot.repositories.VehicleRepository;
import com.scaler.siri.lldprjoects.ParkingLot.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String vehicleNumber, String vehicleOwnerName,
                              VehicleType vehicleType, Long gateId) throws InvalidGateException {
        //return null;
        /*
        1.Get the Vehicle details from DB
        2. Get the gate details from DB
        3. Create a Ticket object
        4. Assign parking spot
        5. Return ticket object
         */
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> optionalGate = gateRepository.findGateByID(gateId);
        if (optionalGate.isEmpty()) {
            throw new InvalidGateException("Gate with this Id "+ gateId + " doesn't exit");
        }
        Gate gate = optionalGate.get();
        ticket.setGate(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Vehicle savedVehicle = null;
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        if(optionalVehicle.isEmpty()){
            Vehicle newVehicle = new Vehicle();
            newVehicle.setNumber(vehicleNumber);
            newVehicle.setVehicleType(vehicleType);
            newVehicle.setOwnerName(vehicleOwnerName);

            savedVehicle = vehicleRepository.save(newVehicle);
        }
        else{
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        // Assign Parking spot
        Optional<ParkingLot> parkingLot = parkingLotRepository.findByGateId(gateId);

        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy = parkingLot.get().getParkingSpotAssignmentStrategy();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getStrategy(parkingSpotAssignmentStrategy);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(gate, vehicleType);
        ticket.setParkingSpot(parkingSpot);

        return ticketRepository.save(ticket);

    }
}
