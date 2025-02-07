package com.client.cinema.model;

import com.client.cinema.model.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Film extends BaseEntity {

    @Column
    @NotNull
    private String nomeFilm;

    @Column
    @NotNull
    private Integer durataFilm;

    @Column
    @NotNull
    private List<String> castCompleto;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Proiezione> proiezioneList = new HashSet<>();
}
