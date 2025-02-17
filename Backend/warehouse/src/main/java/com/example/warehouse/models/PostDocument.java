package com.example.warehouse.models;

import java.time.LocalDateTime;
import java.util.List;

public class PostDocument {
    private List<PostDocumentItem> postDocumentItems;

    private String opisDokument;

    private String tipDokumenta;


    private Long idSkladiste;

    private Long idSkladistar;

    public PostDocument(List<PostDocumentItem> postDocumentItems, String opisDokument, String tipDokumenta, Long idSkladiste, Long idSkladistar) {
        this.postDocumentItems = postDocumentItems;
        this.opisDokument = opisDokument;
        this.tipDokumenta = tipDokumenta;
        this.idSkladiste = idSkladiste;
        this.idSkladistar = idSkladistar;
    }

    public List<PostDocumentItem> getPostDocumentItems() {
        return postDocumentItems;
    }

    public void setPostDocumentItems(List<PostDocumentItem> postDocumentItems) {
        this.postDocumentItems = postDocumentItems;
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
