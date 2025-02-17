package com.example.warehouse.repositories;

import com.example.warehouse.entities.Skladistar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkladistarRepository extends JpaRepository<Skladistar,Long> {

    Skladistar findByKorisnickoImeSkladistarAndLozinkaSkladistar(String korisnickoImeSkladistar, String lozinkaSkladistar);
}
