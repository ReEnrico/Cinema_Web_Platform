package com.client.cinema.service;

import com.client.cinema.model.Sala;
import com.client.cinema.view.sala.DettaglioSala;
import com.client.cinema.view.sala.NuovaSala;

public interface SalaService extends BaseService<Sala, Long>{
    DettaglioSala registraNuovaSala(NuovaSala nuovaSala);
}
