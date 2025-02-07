package com.client.cinema.service.impl;

import com.client.cinema.model.base.Identifiable;
import com.client.cinema.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T extends Identifiable<ID>, ID, R extends JpaRepository<T, ID>> implements BaseService<T, ID> {

    private final R baseRepository;

    public BaseServiceImpl(R baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Optional<T> findOne(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    public T createOrUpdate(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public void deleteOne(ID id) {
        baseRepository.deleteById(id);
    }
}
