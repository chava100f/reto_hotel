package com.chava100f.dondecaigas_app_backend.service.impl;

import com.chava100f.dondecaigas_app_backend.model.Room;
import com.chava100f.dondecaigas_app_backend.repo.IGenericRepo;
import com.chava100f.dondecaigas_app_backend.repo.IRoomRepo;
import com.chava100f.dondecaigas_app_backend.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl extends CRUDServiceImpl<Room, Integer> implements IRoomService {

    private final IRoomRepo repo;

    @Override
    protected IGenericRepo<Room, Integer> getConsultRepo() {
        return repo;
    }
}
