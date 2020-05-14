package com.nisansan.cukar.model;

public class DataCutiModel {

    private String id_cuti;
    private String jumlah_cuti;
    private String tgl_cuti;
    private String keterangan_cuti;
    private String status_approval;

    public DataCutiModel(){

    }

    public DataCutiModel(String id_cuti, String jumlah_cuti, String tgl_cuti, String keterangan_cuti, String status_approval) {
        this.id_cuti = id_cuti;
        this.jumlah_cuti = jumlah_cuti;
        this.tgl_cuti = tgl_cuti;
        this.keterangan_cuti = keterangan_cuti;
        this.status_approval = status_approval;
    }

    public String getId_cuti() {
        return id_cuti;
    }

    public void setId_cuti(String id_cuti) {
        this.id_cuti = id_cuti;
    }

    public String getJumlah_cuti() {
        return jumlah_cuti;
    }

    public void setJumlah_cuti(String jumlah_cuti) {
        this.jumlah_cuti = jumlah_cuti;
    }

    public String getTgl_cuti() {
        return tgl_cuti;
    }

    public void setTgl_cuti(String tgl_cuti) {
        this.tgl_cuti = tgl_cuti;
    }

    public String getKeterangan_cuti() {
        return keterangan_cuti;
    }

    public void setKeterangan_cuti(String keterangan_cuti) {
        this.keterangan_cuti = keterangan_cuti;
    }

    public String getStatus_approval() {
        return status_approval;
    }

    public void setStatus_approval(String status_approval) {
        this.status_approval = status_approval;
    }
}
