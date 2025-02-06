package com.client.cinema.model;

import com.client.cinema.model.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sala")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Sala extends BaseEntity {

    @Column
    @NotNull
    private String nomeSala;

    //TODO: trovare un modo per rendere questo campo modificabile solo con ruolo specifico
    @Column
    @NotNull
    private int numeroMassimoPosti;

    @Column
    @NotNull
    private int postiPerFila;

    @Column
    @NotNull
    private int numeroFile;

    @Column
    private int postiPrenotati;


  @ManyToMany
  @JoinTable(
          name = "sala_proiezioni",
          joinColumns = @JoinColumn(name = "sala_id"),
          inverseJoinColumns = @JoinColumn(name = "proiezione_id")
    )
    private Set<Proiezione> proiezioneList = new HashSet<>();
}
