package com.scaler.siri.lldprjoects.ParkingLot.repositories;

import com.scaler.siri.lldprjoects.ParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private Map<Long, Ticket> ticketMap = new HashMap();
    private Long ticketID = 0L;

    public Ticket save(Ticket ticket) {
        if(ticket.getId() == 0){
            ticketID++;
            ticket.setId(ticketID);
        }
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    public Optional<Ticket> findById(Long id) {
        if(ticketMap.containsKey(id)){
            return Optional.ofNullable(ticketMap.get(id));
        }
        return null;
    }
}
