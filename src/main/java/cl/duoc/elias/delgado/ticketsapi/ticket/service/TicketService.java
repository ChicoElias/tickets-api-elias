package cl.duoc.elias.delgado.ticketsapi.ticket.service;

import cl.duoc.elias.delgado.ticketsapi.ticket.dto.TicketDTO;

import java.util.List;

public interface TicketService {

    TicketDTO create(TicketDTO dto);

    TicketDTO findById(Long id);

    List<TicketDTO> findAll();

    TicketDTO update(Long id, TicketDTO dto);

    void delete(Long id);
}
