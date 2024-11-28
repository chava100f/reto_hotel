package com.chava100f.dondecaigas_app_backend.service.impl;

import com.chava100f.dondecaigas_app_backend.exception.ModelNotFoundException;
import com.chava100f.dondecaigas_app_backend.repo.IGenericRepo;
import com.chava100f.dondecaigas_app_backend.service.ICRUDService;

import java.util.List;

public abstract class CRUDServiceImpl <T, ID> implements ICRUDService <T, ID>{

    protected abstract IGenericRepo <T, ID> getConsultRepo();

    @Override
    public T save(T t) {
        return getConsultRepo().save(t);
    }

    @Override
    public T update(ID id, T t) {
        getConsultRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id));
        return getConsultRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getConsultRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getConsultRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) {
        getConsultRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id));
        getConsultRepo().deleteById(id);
    }
}
