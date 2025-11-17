package cl.duoc.elias.delgado.ticketsapi.ticket.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketPriority prioridad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus estado;
}
