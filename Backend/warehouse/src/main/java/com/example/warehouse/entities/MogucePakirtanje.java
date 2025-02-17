package com.example.warehouse.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MogucePakirtanje {
    @Id
    @Column(name = "idMogucePakiranje_")
    private Long idMogucePakiranje;

    @Column(name = "imeMogucePakiranje_")
    private String imeMogucePakiranje;

    @Column(name = "kolicinaPakiranja")
    private  Integer kolicinaPakiranja;

    @Column (name = "brojArtikala")
    private Integer brojArtikala;

    @ManyToOne
    @JoinColumn(name = "idSkladiste")
    private Skladiste skladiste;

    @ManyToOne
    @JoinColumn(name = "idArtikl")
    private Artikl artikl;

    @OneToMany(mappedBy = "mogucePakirtanje")
    private List<StavkaPromjene> stavkaPromjene;

    public Long getIdMogucePakiranje() {
        return idMogucePakiranje;
    }

    public void setIdMogucePakiranje(Long idMogucePakiranje) {
        this.idMogucePakiranje = idMogucePakiranje;
    }

    public String getImeMogucePakiranje() {
        return imeMogucePakiranje;
    }

    public void setImeMogucePakiranje(String imeMogucePakiranje) {
        this.imeMogucePakiranje = imeMogucePakiranje;
    }

    public Integer getKolicinaPakiranja() {
        return kolicinaPakiranja;
    }

    public void setKolicinaPakiranja(Integer kolicinaPakiranja) {
        this.kolicinaPakiranja = kolicinaPakiranja;
    }

    public Integer getBrojArtikala() {
        return brojArtikala;
    }

    public void setBrojArtikala(Integer brojArtikala) {
        this.brojArtikala = brojArtikala;
    }

    public Skladiste getSkladiste() {
        return skladiste;
    }

    public void setSkladiste(Skladiste skladiste) {
        this.skladiste = skladiste;
    }

    public Artikl getArtikl() {
        return artikl;
    }

    public void setArtikl(Artikl artikl) {
        this.artikl = artikl;
    }
}
