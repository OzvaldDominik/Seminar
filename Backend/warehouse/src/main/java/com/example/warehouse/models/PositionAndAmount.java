package com.example.warehouse.models;

public class PositionAndAmount {
    private Long idPozicija;
    private String oznakaPozicija;

    private Long idMogucePakiranje;

    private String imeMogucePakiranje;

    private Long trenutnaKolicina;

    public PositionAndAmount(Long idPozicija, String oznakaPozicija, Long idMogucePakiranje, String imeMogucePakiranje, Long trenutnaKolicina) {
        this.idPozicija = idPozicija;
        this.oznakaPozicija = oznakaPozicija;
        this.idMogucePakiranje = idMogucePakiranje;
        this.imeMogucePakiranje = imeMogucePakiranje;
        this.trenutnaKolicina = trenutnaKolicina;
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

    public Long getTrenutnaKolicina() {
        return trenutnaKolicina;
    }

    public void setTrenutnaKolicina(Long trenutnaKolicina) {
        this.trenutnaKolicina = trenutnaKolicina;
    }
}
