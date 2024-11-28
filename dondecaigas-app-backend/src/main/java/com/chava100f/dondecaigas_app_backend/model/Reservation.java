package com.chava100f.dondecaigas_app_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Reservation {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private LocalDateTime checkInDate;

    @Column(nullable = false)
    private LocalDateTime checkOutDate;

    @ManyToOne //FK Foreign Key
    @JoinColumn(name = "id_room", nullable = false, foreignKey = @ForeignKey(name = "FK_RESERVATION_ROOM"))
    private Room room;
}
