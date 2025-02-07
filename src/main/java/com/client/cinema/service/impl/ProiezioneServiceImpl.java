package com.client.cinema.service.impl;

import com.client.cinema.model.Proiezione;
import com.client.cinema.repository.ProiezioneRepository;
import com.client.cinema.service.ProiezioneService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProiezioneServiceImpl extends BaseServiceImpl<Proiezione, Long, ProiezioneRepository> implements ProiezioneService {

    public ProiezioneServiceImpl(ProiezioneRepository baseRepository) {
        super(baseRepository);
    }
}
