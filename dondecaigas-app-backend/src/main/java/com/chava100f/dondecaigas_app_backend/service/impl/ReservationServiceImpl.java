package com.chava100f.dondecaigas_app_backend.service.impl;

import com.chava100f.dondecaigas_app_backend.model.Reservation;
import com.chava100f.dondecaigas_app_backend.repo.IGenericRepo;
import com.chava100f.dondecaigas_app_backend.repo.IReservationRepo;
import com.chava100f.dondecaigas_app_backend.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl extends CRUDServiceImpl<Reservation, Integer> implements IReservationService {

    private final IReservationRepo repo;

    @Override
    protected IGenericRepo<Reservation, Integer> getConsultRepo() {return repo;}
}
