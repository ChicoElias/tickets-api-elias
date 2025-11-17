package cl.duoc.elias.delgado.ticketsapi.ticket.repository;

import cl.duoc.elias.delgado.ticketsapi.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
