package com.chava100f.dondecaigas_app_backend.controller;

import com.chava100f.dondecaigas_app_backend.dto.ReservationDTO;
import com.chava100f.dondecaigas_app_backend.model.Reservation;
import com.chava100f.dondecaigas_app_backend.service.IReservationService;
import com.chava100f.dondecaigas_app_backend.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final IReservationService service;

    private final MapperUtil mapper;


    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAll() {
        List<ReservationDTO> list = mapper.mapList(service.findAll(), ReservationDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> findById(@PathVariable("id") Integer id) {
        Reservation r = service.findById(id);
        return ResponseEntity.ok(mapper.map(r, ReservationDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ReservationDTO dto) {
        Reservation r = service.save(mapper.map(dto, Reservation.class));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(r.getIdReservation()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> update(@PathVariable("id") Integer id, @RequestBody ReservationDTO dto) {
        Reservation r = service.update(id, mapper.map(dto, Reservation.class));
        return ResponseEntity.ok(mapper.map(r, ReservationDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
