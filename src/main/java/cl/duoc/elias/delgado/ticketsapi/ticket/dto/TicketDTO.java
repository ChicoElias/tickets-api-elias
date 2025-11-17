package cl.duoc.elias.delgado.ticketsapi.ticket.dto;

import cl.duoc.elias.delgado.ticketsapi.ticket.model.TicketPriority;
import cl.duoc.elias.delgado.ticketsapi.ticket.model.TicketStatus;
import lombok.Data;

@Data
public class TicketDTO {
    private Long id;
    private String descripcion;
    private TicketPriority prioridad;
    private TicketStatus estado;
}
