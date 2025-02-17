package com.example.warehouse.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pozicija")
public class Pozicija {
    @Id
    @Column(name = "idPozicija_")
    private Long idPozicija;

    @Column(name = "oznakaPozicija")
    private String oznakaPozicija;
    @ManyToOne
    @JoinColumn(name = "idSkladiste")
    private Skladiste skladiste;

    @OneToMany(mappedBy = "pozicija")
    private List<StavkaPromjene> stavkaPromjene;

    public Long getIdPozicija() {
        return idPozicija;
    }

    public void setIdPozicija(Long idPozicija) {
        this.idPozicija = idPozicija;
    }

    public String getOznakaPozicija() {
        return oznakaPozicija;
    }

    public void setOznakaPozicija(String oznakaPozicija) {
        this.oznakaPozicija = oznakaPozicija;
    }

    public Skladiste getSkladiste() {
        return skladiste;
    }

    @Override
    public String toString() {
        return "Pozicija{" +
                "idPozicija=" + idPozicija +
                ", oznakaPozicija='" + oznakaPozicija + '\'' +
                ", skladiste=" + skladiste.getIdSkladiste() +
                '}';
    }
}
