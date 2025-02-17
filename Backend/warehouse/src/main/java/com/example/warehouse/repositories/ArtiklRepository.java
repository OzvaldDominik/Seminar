package com.example.warehouse.repositories;

import com.example.warehouse.entities.Artikl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtiklRepository extends JpaRepository<Artikl,Long> {
}
