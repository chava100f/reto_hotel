package com.chava100f.dondecaigas_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private Integer idRoom;
    private String number;
    private String type;
    private Double price;
    private Boolean available;
}
