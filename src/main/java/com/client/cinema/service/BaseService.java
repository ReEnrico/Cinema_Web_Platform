package com.client.cinema.service;

import com.client.cinema.model.base.Identifiable;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends Identifiable<ID>, ID> {

    List<T> findAll();
    Optional<T> findOne(ID id);

    T createOrUpdate(T entity);

    void deleteOne(ID id);

}
