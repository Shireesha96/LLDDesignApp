package com.scaler.siri.lldprjoects.ParkingLot;

import com.scaler.siri.lldprjoects.ParkingLot.controllers.TicketController;
import com.scaler.siri.lldprjoects.ParkingLot.dtos.IssueTicketRequestDTO;
import com.scaler.siri.lldprjoects.ParkingLot.dtos.IssueTicketResponseDTO;
import com.scaler.siri.lldprjoects.ParkingLot.models.VehicleType;
import com.scaler.siri.lldprjoects.ParkingLot.repositories.GateRepository;
import com.scaler.siri.lldprjoects.ParkingLot.repositories.ParkingLotRepository;
import com.scaler.siri.lldprjoects.ParkingLot.repositories.TicketRepository;
import com.scaler.siri.lldprjoects.ParkingLot.repositories.VehicleRepository;
import com.scaler.siri.lldprjoects.ParkingLot.services.TicketService;

public class ParkingLotMain {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(gateRepository);
        VehicleRepository vehicleRepository = new VehicleRepository();


        // we have to create the dependency objects in order and pass it
        // hence we use Spring framework as it gets difficult for larger projects
        // Spring Framework resolves dependencies in correct order (Topological sort)
        // core logic of Spring Framework in Dependency Injection
        // It uses IOC - Inversion Of Control
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setGateId(1L);
        issueTicketRequestDTO.setVehicleType(VehicleType.SUV);
        issueTicketRequestDTO.setVehicleDriverName("Shireesha");
        issueTicketRequestDTO.setVehicleNumber("ASDF23432");

        IssueTicketResponseDTO responseDTO = ticketController.issueTicket(issueTicketRequestDTO);
    }
}
