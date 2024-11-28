package com.chava100f.dondecaigas_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

    private Integer idReservation;
    private String customerName;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private Integer idRoom;
}
