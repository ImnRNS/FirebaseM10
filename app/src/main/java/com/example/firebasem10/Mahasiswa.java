package com.example.firebasem10;
public class Mahasiswa {

    private String id;
    private String name;
    private String NIM;

    public Mahasiswa() {
    }

    public Mahasiswa(String id, String name, String NIM) {
        this.id = id;
        this.name = name;
        this.NIM = NIM;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNIM() {
        return NIM;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }
}
