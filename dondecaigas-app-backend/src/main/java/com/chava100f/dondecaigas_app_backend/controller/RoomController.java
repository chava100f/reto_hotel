package com.chava100f.dondecaigas_app_backend.controller;

import com.chava100f.dondecaigas_app_backend.dto.RoomDTO;
import com.chava100f.dondecaigas_app_backend.model.Room;
import com.chava100f.dondecaigas_app_backend.service.IRoomService;
import com.chava100f.dondecaigas_app_backend.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final IRoomService service;

    private final MapperUtil mapper;


    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAll() {
        List<RoomDTO> list = mapper.mapList(service.findAll(), RoomDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findById(@PathVariable("id") Integer id) {
        Room r = service.findById(id);
        return ResponseEntity.ok(mapper.map(r, RoomDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RoomDTO dto) {
        Room r = service.save(mapper.map(dto, Room.class));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(r.getIdRoom()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> update(@PathVariable("id") Integer id, @RequestBody RoomDTO dto) {
        Room r = service.update(id, mapper.map(dto, Room.class));
        return ResponseEntity.ok(mapper.map(r, RoomDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
