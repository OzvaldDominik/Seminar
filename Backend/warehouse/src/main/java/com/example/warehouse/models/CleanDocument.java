package com.example.warehouse.models;

import com.example.warehouse.entities.Dokument;
import com.example.warehouse.entities.Skladiste;

import java.time.LocalDateTime;

public class CleanDocument {

    private int idDokument;
    private LocalDateTime vreijemeDokument;
    private String opisDokument;

    private String tipDokumenta;


    private Long idSkladiste;

    private Long idSkladistar;

    private String imeSkladistar;

    public CleanDocument(Dokument dokument){
        this.idDokument=dokument.getIdDokument();
        this.vreijemeDokument=dokument.getVreijemeDokument();
        this.tipDokumenta=dokument.getTipDokumenta();
        this.opisDokument=dokument.getOpisDokument();
        this.idSkladiste=dokument.getSkladiste().getIdSkladiste();
        this.idSkladistar=dokument.getSkladistar().getIdSkladistar();
        this.imeSkladistar=dokument.getSkladistar().getImeSkladistar() + " " + dokument.getSkladistar().getPrezimeSkladistar();
    }

    public CleanDocument(int idDokument, LocalDateTime vreijemeDokument, String opisDokument, String tipDokumenta, Long idSkladiste, Long idSkladistar, String imeSkladistar) {
        this.idDokument = idDokument;
        this.vreijemeDokument = vreijemeDokument;
        this.opisDokument = opisDokument;
        this.tipDokumenta = tipDokumenta;
        this.idSkladiste = idSkladiste;
        this.idSkladistar = idSkladistar;
        this.imeSkladistar = imeSkladistar;
    }

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

    public Long getIdSkladiste() {
        return idSkladiste;
    }

    public String getImeSkladistar() {
        return imeSkladistar;
    }

    public void setImeSkladistar(String imeSkladistar) {
        this.imeSkladistar = imeSkladistar;
    }

    public void setIdSkladiste(Long idSkladiste) {
        this.idSkladiste = idSkladiste;
    }

    public Long getIdSkladistar() {
        return idSkladistar;
    }

    public void setIdSkladistar(Long idSkladistar) {
        this.idSkladistar = idSkladistar;
    }
}
