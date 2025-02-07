package com.client.cinema.service.impl;

import com.client.cinema.model.Film;
import com.client.cinema.repository.FilmRepository;
import com.client.cinema.service.FilmService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FilmServiceImpl extends BaseServiceImpl<Film, Long, FilmRepository> implements FilmService {

    public FilmServiceImpl(FilmRepository baseRepository) {
        super(baseRepository);
    }
}
