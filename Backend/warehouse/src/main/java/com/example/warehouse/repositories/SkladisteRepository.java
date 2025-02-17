package com.example.warehouse.repositories;

import com.example.warehouse.entities.Skladiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkladisteRepository extends JpaRepository<Skladiste,Long> {
    List<Skladiste> findAllBySkladistarIdSkladistar(Long skladistarId);
}
