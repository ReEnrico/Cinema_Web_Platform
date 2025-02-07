package com.client.cinema.service.impl;

import com.client.cinema.model.Sala;
import com.client.cinema.repository.SalaRepository;
import com.client.cinema.service.SalaService;
import com.client.cinema.utils.SalaConverter;
import com.client.cinema.view.sala.DettaglioSala;
import com.client.cinema.view.sala.NuovaSala;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Log4j2
public class SalaServiceImpl extends BaseServiceImpl<Sala, Long, SalaRepository> implements SalaService {

    public SalaServiceImpl(SalaRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public DettaglioSala registraNuovaSala(NuovaSala nuovaSala) {
        log.info("Inside service");
        Sala saltaDaSalvare = SalaConverter.nuovaSalaToEntity(nuovaSala);
        try {
            //TODO: custom exception per impedire nomi dupplicati, l'annotazione non agisce
            return SalaConverter.entityToDettaglioSala(super.createOrUpdate(saltaDaSalvare));
        } catch (ConstraintViolationException e) {
            log.error("Ecception: {}", e.toString());
            //TODO: gestire le eccezioni per possibili dati con stesso nomeSala
            throw new RuntimeException(e);
        }

    }
}
