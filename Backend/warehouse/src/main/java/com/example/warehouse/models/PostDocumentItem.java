package com.example.warehouse.models;

public class PostDocumentItem {
    private int razlika;
    private Long idPozicija;

    private String oznakaPozicija;
    private String imeMogucePakiranje;
    private Long idMogucePakiranje;

    public PostDocumentItem(int razlika, Long idPozicija, Long idMogucePakiranje,String oznakaPozicija,String imeMogucePakiranje) {
        this.razlika = razlika;
        this.idPozicija = idPozicija;
        this.idMogucePakiranje = idMogucePakiranje;
        this.oznakaPozicija=oznakaPozicija;
        this.imeMogucePakiranje=imeMogucePakiranje;
    }

    public int getRazlika() {
        return razlika;
    }

    public void setRazlika(int razlika) {
        this.razlika = razlika;
    }

    public Long getIdPozicija() {
        return idPozicija;
    }

    public void setIdPozicija(Long idPozicija) {
        this.idPozicija = idPozicija;
    }

    public Long getIdMogucePakiranje() {
        return idMogucePakiranje;
    }

    public void setIdMogucePakiranje(Long idMogucePakiranje) {
        this.idMogucePakiranje = idMogucePakiranje;
    }

    public String getOznakaPozicija() {
        return oznakaPozicija;
    }

    public void setOznakaPozicija(String oznakaPozicija) {
        this.oznakaPozicija = oznakaPozicija;
    }

    public String getImeMogucePakiranje() {
        return imeMogucePakiranje;
    }

    public void setImeMogucePakiranje(String imeMogucePakiranje) {
        this.imeMogucePakiranje = imeMogucePakiranje;
    }
}
