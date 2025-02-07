package com.client.cinema.repository;

import com.client.cinema.model.Proiezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProiezioneRepository extends JpaRepository<Proiezione, Long> {
}
