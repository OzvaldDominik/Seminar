package com.example.warehouse.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "dokument")
public class Dokument {
    @Id
    @Column(name = "idDokument")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDokument;

    @Column(name = "vreijemeDokument")
    private LocalDateTime vreijemeDokument;

    @Column(name = "opisDokument_")
    private String opisDokument;

    @Column(name = "tipDokumenta")
    private String tipDokumenta;

    @ManyToOne
    @JoinColumn(name = "idSkladiste")
    private Skladiste skladiste;

    @ManyToOne
    @JoinColumn(name = "idSkladistar")
    private Skladistar skladistar;

    @OneToMany(mappedBy = "dokument")
    private List<StavkaPromjene> stavkaPromjene;

    public int getIdDokument() {
        return idDokument;
    }

    public void setIdDokument(int idDokument) {
        this.idDokument = idDokument;
    }

    public LocalDateTime getVreijemeDokument() {
        return vreijemeDokument;
    }

    public void setVreijemeDokument(LocalDateTime vreijemeDokument) {
        this.vreijemeDokument = vreijemeDokument;
    }

    public String getOpisDokument() {
        return opisDokument;
    }

    public void setOpisDokument(String opisDokument) {
        this.opisDokument = opisDokument;
    }

    public String getTipDokumenta() {
        return tipDokumenta;
    }

    public void setTipDokumenta(String tipDokumenta) {
        this.tipDokumenta = tipDokumenta;
    }

    public Skladiste getSkladiste() {
        return skladiste;
    }

    public void setSkladiste(Skladiste skladiste) {
        this.skladiste = skladiste;
    }

    public Skladistar getSkladistar() {
        return skladistar;
    }

    public void setSkladistar(Skladistar skladistar) {
        this.skladistar = skladistar;
    }
}
