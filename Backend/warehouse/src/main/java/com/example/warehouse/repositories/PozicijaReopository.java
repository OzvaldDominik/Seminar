package com.example.warehouse.repositories;

import com.example.warehouse.entities.Pozicija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PozicijaReopository extends JpaRepository<Pozicija,Long> {
    List<Pozicija> findAllBySkladisteIdSkladiste(Long idSkladiste);
}
