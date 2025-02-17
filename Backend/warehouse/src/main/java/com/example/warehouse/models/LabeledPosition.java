package com.example.warehouse.models;

import com.example.warehouse.entities.Pozicija;

public class LabeledPosition {
    private Long idPozicija;
    private String oznakaPozicija;

    public LabeledPosition(Pozicija pozicija) {
        this.idPozicija=pozicija.getIdPozicija();
        this.oznakaPozicija=pozicija.getOznakaPozicija();
    }

    public LabeledPosition(Long idPozicija, String oznakaPozicija) {
        this.idPozicija = idPozicija;
        this.oznakaPozicija = oznakaPozicija;
    }

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

}
