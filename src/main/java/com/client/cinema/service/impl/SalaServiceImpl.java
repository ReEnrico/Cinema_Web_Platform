package com.client.cinema.service.impl;

import com.client.cinema.model.Sala;
import com.client.cinema.repository.SalaRepository;
import com.client.cinema.service.SalaService;
import com.client.cinema.utils.SalaConverter;
import com.client.cinema.view.sala.DettaglioSala;
import com.client.cinema.view.sala.ModificaSala;
import com.client.cinema.view.sala.NuovaSala;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public DettaglioSala modificaSalaEsistente(Long sala_id, ModificaSala modificaSala) {
        Optional<Sala> existingSala = super.findOne(sala_id);
        if (existingSala.isPresent()) {
            Sala salaToUpdate = existingSala.get();
            salaToUpdate.setNomeSala(modificaSala.getNomeSala());
            salaToUpdate.setNumeroMassimoPosti(modificaSala.getNumeroMassimoPosti());
            salaToUpdate.setPostiPerFila(modificaSala.getPostiPerFila());
            salaToUpdate.setNumeroFile(modificaSala.getNumeroFile());
           return  SalaConverter.entityToDettaglioSala(
                   super.createOrUpdate(salaToUpdate)
           );
        } else {
            //TODO: customizzare l'eccezione
            throw new RuntimeException();
        }
    }

    @Override
    public DettaglioSala visualizzaSingolaSala(Long salaId) {
        Optional<Sala> existingSala = super.findOne(salaId);
        if (existingSala.isPresent()) {
            return SalaConverter.entityToDettaglioSala(existingSala.get());
        } else {
            throw new RuntimeException();
        }
    }
}
