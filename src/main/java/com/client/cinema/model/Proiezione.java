package com.client.cinema.model;

import com.client.cinema.model.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proiezione")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Proiezione extends BaseEntity {

    @Column
    @NotNull
    private LocalDateTime oraInizio;

    @Column
    @NotNull
    private Long prezzoBiglietto;

    @ManyToMany(mappedBy = "proiezioneList")
    private Set<Sala> salaList = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private Film film;
}
