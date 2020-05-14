package com.nisansan.cukar.model;

public class UserProfile {

    private String fullname;
    private String id_user;
    private String email;
    private String password;
    private String jabatan;

    public UserProfile() {

    }

    public UserProfile(String fullname, String id_user, String email, String password, String jabatan) {
        this.fullname = fullname;
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.jabatan = jabatan;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
