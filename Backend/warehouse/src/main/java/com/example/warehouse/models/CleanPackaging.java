package com.example.warehouse.models;

import com.example.warehouse.entities.MogucePakirtanje;

public class CleanPackaging {
    private Long idMogucePakiranje;
    private String imeMogucePakiranje;
    private  Integer kolicinaPakiranja;
    private Integer brojArtikala;

    public CleanPackaging(MogucePakirtanje mogucePakirtanje){
        this.idMogucePakiranje=mogucePakirtanje.getIdMogucePakiranje();
        this.imeMogucePakiranje=mogucePakirtanje.getImeMogucePakiranje();
        this.kolicinaPakiranja=mogucePakirtanje.getKolicinaPakiranja();
        this.brojArtikala=mogucePakirtanje.getBrojArtikala();
    }
    public CleanPackaging(Long idMogucePakiranje, String imeMogucePakiranje, Integer kolicinaPakiranja, Integer brojArtikala) {
        this.idMogucePakiranje = idMogucePakiranje;
        this.imeMogucePakiranje = imeMogucePakiranje;
        this.kolicinaPakiranja = kolicinaPakiranja;
        this.brojArtikala = brojArtikala;
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
}
