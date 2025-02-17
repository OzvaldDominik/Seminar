package com.example.warehouse.repositories;

import com.example.warehouse.entities.MogucePakirtanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MogucePakiranjeRepository  extends JpaRepository<MogucePakirtanje,Long> {
    List<MogucePakirtanje> findAllByArtiklIdArtikl(Long idArtikl);
    List<MogucePakirtanje> findAllBySkladisteIdSkladiste(Long idSkladiste);
}
