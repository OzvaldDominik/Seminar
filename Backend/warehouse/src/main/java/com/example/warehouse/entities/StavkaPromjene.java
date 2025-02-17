package com.example.warehouse.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "stavkaPromjene")
public class StavkaPromjene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStavkaPromjene;

    @Column(name = "Razlika", nullable = false)
    private int razlika;

    @ManyToOne
    @JoinColumn(name = "idDokument")
    private Dokument dokument;

    @ManyToOne
    @JoinColumn(name = "idPozicija_")
    private Pozicija pozicija;

    @ManyToOne
    @JoinColumn(name = "idMogucePakiranje_")
    private MogucePakirtanje mogucePakirtanje;

    public Long getIdStavkaPromjene() {
        return idStavkaPromjene;
    }

    public void setIdStavkaPromjene(Long idStavkaPromjene) {
        this.idStavkaPromjene = idStavkaPromjene;
    }

    public int getRazlika() {
        return razlika;
    }

    public void setRazlika(int razlika) {
        this.razlika = razlika;
    }

    public Dokument getDokument() {
        return dokument;
    }

    public void setDokument(Dokument dokument) {
        this.dokument = dokument;
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    public MogucePakirtanje getMogucePakirtanje() {
        return mogucePakirtanje;
    }

    public void setMogucePakirtanje(MogucePakirtanje mogucePakirtanje) {
        this.mogucePakirtanje = mogucePakirtanje;
    }
}
