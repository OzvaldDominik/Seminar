package com.example.warehouse.models;

import com.example.warehouse.entities.StavkaPromjene;

public class CleanDocumentItem {
    private Long idStavkaPromjene;
    private int razlika;
    private Long idPozicija;
    private String oznakaPozicija;
    private Long idMogucePakiranje;
    private String imeMogucePakiranje;
    private int idDokumnet;

    public CleanDocumentItem(StavkaPromjene stavkaPromjene){
        this.idStavkaPromjene=stavkaPromjene.getIdStavkaPromjene();
        this.razlika=stavkaPromjene.getRazlika();
        this.idPozicija=stavkaPromjene.getPozicija().getIdPozicija();
        this.oznakaPozicija =stavkaPromjene.getPozicija().getOznakaPozicija();
        this.idMogucePakiranje=stavkaPromjene.getMogucePakirtanje().getIdMogucePakiranje();
        this.imeMogucePakiranje=stavkaPromjene.getMogucePakirtanje().getImeMogucePakiranje();
        this.idDokumnet=stavkaPromjene.getDokument().getIdDokument();

    }

    public CleanDocumentItem(Long idStavkaPromjene, int razlika, Long idPozicija, String imePozicija, Long idMogucePakiranje, String imeMogucePakiranje, int idDokumnet) {
        this.idStavkaPromjene = idStavkaPromjene;
        this.razlika = razlika;
        this.idPozicija = idPozicija;
        this.oznakaPozicija = imePozicija;
        this.idMogucePakiranje = idMogucePakiranje;
        this.imeMogucePakiranje = imeMogucePakiranje;
        this.idDokumnet = idDokumnet;
    }

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

    public int getIdDokumnet() {
        return idDokumnet;
    }

    public void setIdDokumnet(int idDokumnet) {
        this.idDokumnet = idDokumnet;
    }
}
