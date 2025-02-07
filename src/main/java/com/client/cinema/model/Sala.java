package com.client.cinema.model;

import com.client.cinema.model.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "sala",
        indexes = @Index(name = "idx_nome", columnList = "nomeSala")
)
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
    private Integer numeroMassimoPosti;

    @Column
    @NotNull
    private Integer postiPerFila;

    @Column
    @NotNull
    private Integer numeroFile;

    @Column
    private Integer postiPrenotati;


  @ManyToMany
  @JoinTable(
          name = "sala_proiezioni",
          joinColumns = @JoinColumn(name = "sala_id"),
          inverseJoinColumns = @JoinColumn(name = "proiezione_id")
    )
    private Set<Proiezione> proiezioneList = new HashSet<>();
}
