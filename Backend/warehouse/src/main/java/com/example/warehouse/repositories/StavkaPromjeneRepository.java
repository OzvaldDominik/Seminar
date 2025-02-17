package com.example.warehouse.repositories;

import com.example.warehouse.entities.StavkaPromjene;
import com.example.warehouse.models.PositionAndAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StavkaPromjeneRepository extends JpaRepository<StavkaPromjene,Long> {
    List<StavkaPromjene> findAllByDokumentIdDokument(Long idDokument);
    List<StavkaPromjene> findAllByPozicijaIdPozicija(Long idPozicija);

    @Query("SELECT new com.example.warehouse.models.PositionAndAmount(" +
            "p.idPozicija, p.oznakaPozicija, mp.idMogucePakiranje, mp.imeMogucePakiranje, SUM(sp.razlika)) " +
            "FROM StavkaPromjene sp " +
            "JOIN sp.pozicija p " +
            "JOIN sp.mogucePakirtanje mp " +
            "WHERE sp.dokument.skladiste.id = :idSkladiste " +
            "GROUP BY p.idPozicija,  mp.idMogucePakiranje " +
            "HAVING SUM(sp.razlika) > 0")
    List<PositionAndAmount> findPositionAndAmountForSkladiste(@Param("idSkladiste") Long idSkladiste);

    @Query("SELECT new com.example.warehouse.models.PositionAndAmount(" +
            "p.idPozicija, p.oznakaPozicija, mp.idMogucePakiranje, mp.imeMogucePakiranje, SUM(sp.razlika)) " +
            "FROM StavkaPromjene sp " +
            "JOIN sp.pozicija p " +
            "JOIN sp.mogucePakirtanje mp " +
            "WHERE mp.artikl.id = :idArtikl " +
            "GROUP BY p.idPozicija,  mp.idMogucePakiranje " +
            "HAVING SUM(sp.razlika) > 0")
    List<PositionAndAmount> findPositionAndAmountForArtikl(@Param("idArtikl") Long idArtikl);

    @Query("SELECT new com.example.warehouse.models.PositionAndAmount(" +
            "p.idPozicija, p.oznakaPozicija, mp.idMogucePakiranje, mp.imeMogucePakiranje, SUM(sp.razlika)) " +
            "FROM StavkaPromjene sp " +
            "JOIN sp.pozicija p " +
            "JOIN sp.mogucePakirtanje mp " +
            "WHERE mp.id = :idPakiranje " +
            "GROUP BY p.idPozicija,  mp.idMogucePakiranje " +
            "HAVING SUM(sp.razlika) > 0")
    List<PositionAndAmount> findPositionAndAmountForPakiranje(@Param("idPakiranje") Long idPakiranje);

}
