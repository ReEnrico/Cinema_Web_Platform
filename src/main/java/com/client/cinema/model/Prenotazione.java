package com.client.cinema.model;

import com.client.cinema.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "prenotazione")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Prenotazione extends BaseEntity {

    @Column
    @NotNull
    private String nomePrenotazione;

    @Column
    @NotNull
    private LocalDateTime dataOraPrenotazione;

    @Column
    @NotNull
    private Boolean bigliettoDigitale;

    @Column
    @NotNull
    private Set<String> postiPrenotati;

    @Column
    @NotNull
    private Integer idProiezione;

    @Column
    @NotNull
    private Integer idSala;
}
