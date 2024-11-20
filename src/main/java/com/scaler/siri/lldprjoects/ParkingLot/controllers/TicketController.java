package com.scaler.siri.lldprjoects.ParkingLot.controllers;

import com.scaler.siri.lldprjoects.ParkingLot.dtos.IssueTicketRequestDTO;
import com.scaler.siri.lldprjoects.ParkingLot.dtos.IssueTicketResponseDTO;
import com.scaler.siri.lldprjoects.ParkingLot.models.Ticket;
import com.scaler.siri.lldprjoects.ParkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO) {
        return null;
    }
}
