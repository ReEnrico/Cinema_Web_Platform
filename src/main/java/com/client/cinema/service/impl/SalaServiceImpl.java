package com.client.cinema.service.impl;

import com.client.cinema.model.Sala;
import com.client.cinema.repository.SalaRepository;
import com.client.cinema.service.SalaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SalaServiceImpl extends BaseServiceImpl<Sala, Long, SalaRepository> implements SalaService {

    public SalaServiceImpl(SalaRepository baseRepository) {
        super(baseRepository);
    }
}
