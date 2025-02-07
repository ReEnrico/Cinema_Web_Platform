package com.client.cinema.service.impl;

import com.client.cinema.model.Prenotazione;
import com.client.cinema.repository.PrenotazioneRepository;
import com.client.cinema.service.PrenotazioneService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PrenotazioneServiceImpl extends BaseServiceImpl<Prenotazione, Long, PrenotazioneRepository> implements PrenotazioneService {

    public PrenotazioneServiceImpl(PrenotazioneRepository baseRepository) {
        super(baseRepository);
    }
}
