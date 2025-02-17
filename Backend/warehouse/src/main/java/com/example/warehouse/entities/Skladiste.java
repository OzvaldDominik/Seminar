package com.example.warehouse.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "skladiste")
public class Skladiste {
    @Id
    private Long idSkladiste;
    @Column(name = "nazivSkladiste_")
    private String nazivSkladiste;
    @Column(name = "adresa")
    private String adresa;
    @ManyToMany
    @JoinTable(name = "imaPristup",
                joinColumns = @JoinColumn(name = "idSkladiste"),
                inverseJoinColumns = @JoinColumn(name = "idSkladistar")
    )
    private List<Skladistar> skladistar;

    @OneToMany(mappedBy = "skladiste")
    private List<Pozicija> pozicija;

    @OneToMany(mappedBy = "skladiste")
    private List<MogucePakirtanje> mogucePakirtanje;

    @OneToMany(mappedBy = "skladiste")
    private List<Dokument> dokument;


    public Skladiste() {
    }

    public Skladiste(Long idSkladiste, String nazivSkladiste, String adresa) {
        this.idSkladiste = idSkladiste;
        this.nazivSkladiste = nazivSkladiste;
        this.adresa = adresa;
    }

    public Skladiste(String nazivSkladiste, String adresa) {
        this.nazivSkladiste = nazivSkladiste;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Skladiste{" +
                "idSkladiste=" + idSkladiste +
                ", nazivSkladiste='" + nazivSkladiste + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }

    public Long getIdSkladiste() {
        return idSkladiste;
    }

    public void setIdSkladiste(Long idSkladiste) {
        this.idSkladiste = idSkladiste;
    }

    public String getNazivSkladiste() {
        return nazivSkladiste;
    }

    public void setNazivSkladiste(String nazivSkladiste) {
        this.nazivSkladiste = nazivSkladiste;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}


