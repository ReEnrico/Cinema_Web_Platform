package com.client.cinema.utils;

import com.client.cinema.model.Sala;
import com.client.cinema.view.sala.DettaglioSala;
import com.client.cinema.view.sala.ModificaSala;
import com.client.cinema.view.sala.NuovaSala;

public class SalaConverter {

    public static Sala nuovaSalaToEntity(NuovaSala dto){
        Integer maxposti ;
        if (dto.getNumeroMassimoPosti() != null) {
            maxposti = dto.getNumeroMassimoPosti();
        } else {
            maxposti = dto.getPostiPerFila() * dto.getNumeroFile();
        }
        return Sala.builder()
                .nomeSala(dto.getNomeSala())
                .numeroMassimoPosti(maxposti)
                .postiPerFila(dto.getPostiPerFila())
                .numeroFile(dto.getNumeroFile())
                .build();
    }

    public static DettaglioSala entityToDettaglioSala(Sala entity) {
        return DettaglioSala.builder()
                .id(entity.getId())
                .nomeSala(entity.getNomeSala())
                .numeroMassimoPosti(entity.getNumeroMassimoPosti())
                .postiPerFila(entity.getPostiPerFila())
                .numeroFile(entity.getNumeroFile())
                .build();
    }
}
