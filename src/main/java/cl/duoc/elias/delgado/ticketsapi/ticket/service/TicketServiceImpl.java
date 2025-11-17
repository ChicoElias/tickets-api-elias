package cl.duoc.elias.delgado.ticketsapi.ticket.service;

import cl.duoc.elias.delgado.ticketsapi.ticket.dto.TicketDTO;
import cl.duoc.elias.delgado.ticketsapi.ticket.model.Ticket;
import cl.duoc.elias.delgado.ticketsapi.ticket.model.TicketStatus;
import cl.duoc.elias.delgado.ticketsapi.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    private TicketDTO toDTO(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setDescripcion(ticket.getDescripcion());
        dto.setPrioridad(ticket.getPrioridad());
        dto.setEstado(ticket.getEstado());
        return dto;
    }

    private Ticket toEntity(TicketDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setId(dto.getId());
        ticket.setDescripcion(dto.getDescripcion());
        ticket.setPrioridad(dto.getPrioridad());
        ticket.setEstado(dto.getEstado());
        return ticket;
    }

    @Override
    public TicketDTO create(TicketDTO dto) {
        Ticket ticket = toEntity(dto);
        if (ticket.getEstado() == null) {
            ticket.setEstado(TicketStatus.OPEN);
        }
        Ticket saved = ticketRepository.save(ticket);
        return toDTO(saved);
    }

    @Override
    public TicketDTO findById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ticket no encontrado"));
        return toDTO(ticket);
    }

    @Override
    public List<TicketDTO> findAll() {
        return ticketRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDTO update(Long id, TicketDTO dto) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ticket no encontrado"));

        ticket.setDescripcion(dto.getDescripcion());
        ticket.setPrioridad(dto.getPrioridad());
        ticket.setEstado(dto.getEstado());

        Ticket saved = ticketRepository.save(ticket);
        return toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new NoSuchElementException("Ticket no encontrado");
        }
        ticketRepository.deleteById(id);
    }
}
