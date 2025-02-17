package com.example.warehouse.repositories;

import com.example.warehouse.entities.Dokument;
import com.example.warehouse.models.CleanDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DokumentRepository extends JpaRepository<Dokument,Long> {
    List<Dokument> findAllBySkladisteIdSkladiste(Long idSkladiste);

    @Query("SELECT DISTINCT  new com.example.warehouse.models.CleanDocument(" +
            "d.idDokument, d.vreijemeDokument, d.opisDokument, d.tipDokumenta, " +
            "d.skladiste.id, d.skladistar.id, " +
            "CONCAT(d.skladistar.imeSkladistar, ' ', d.skladistar.prezimeSkladistar)) " +
            "FROM Dokument d " +
            "JOIN d.stavkaPromjene sp " +
            "JOIN sp.mogucePakirtanje mp " +
            "WHERE mp.artikl.id = :idArtikl")
    List<CleanDocument> findDokumnetByArtikl(@Param("idArtikl") Long idArtikl);
}
