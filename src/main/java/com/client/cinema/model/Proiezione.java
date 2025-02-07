package com.client.cinema.model;

import com.client.cinema.model.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "proiezione",
        indexes = @Index(name = "idx_orario", columnList = "dataOraInizio")
)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Proiezione extends BaseEntity {

    @Column
    @NotNull
    private LocalDateTime dataOraInizio;

    @Column
    @NotNull
    private Long prezzoBiglietto;

    @ManyToMany(mappedBy = "proiezioneList")
    @Size(message = "Controllo lista non vuota", min = 1)
    private Set<Sala> salaList = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    @NotNull
    private Film film;
}
