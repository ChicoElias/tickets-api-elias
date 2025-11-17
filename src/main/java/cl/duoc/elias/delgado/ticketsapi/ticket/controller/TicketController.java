package cl.duoc.elias.delgado.ticketsapi.ticket.controller;

import cl.duoc.elias.delgado.ticketsapi.ticket.dto.TicketDTO;
import cl.duoc.elias.delgado.ticketsapi.ticket.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketDTO> create(@RequestBody TicketDTO dto) {
        return ResponseEntity.ok(ticketService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<TicketDTO>> findAll() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> update(@PathVariable Long id, @RequestBody TicketDTO dto) {
        return ResponseEntity.ok(ticketService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ticketService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
