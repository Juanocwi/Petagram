package com.espeletia.petagrams3;

public class Mascotas {
    private String tvNombre;
    private String tvLikes;
    private int ivFoto;
    private int ivLike;
    private int ivTLikes;

    public Mascotas(String tvNombre, String tvLikes, int ivFoto, int ivLike, int ivTLikes) {
        this.tvNombre = tvNombre;
        this.tvLikes = tvLikes;
        this.ivFoto = ivFoto;
        this.ivLike = ivLike;
        this.ivTLikes = ivTLikes;
    }



    public String getTvNombre() {
        return tvNombre;
    }

    public void setTvNombre(String tvNombre) {
        this.tvNombre = tvNombre;
    }
    public String getTvLikes() {
        return tvLikes;
    }

    public void setTvLikes(String tvLikes) {
        this.tvLikes = tvLikes;
    }

    public int getIvFoto() {
        return ivFoto;
    }

    public void setIvFoto(int ivFoto) {
        this.ivFoto = ivFoto;
    }

    public int getIvLike() {
        return ivLike;
    }

    public void setIvLike(int ivLike) {
        this.ivLike = ivLike;
    }

    public int getIvTLikes() {
        return ivTLikes;
    }

    public void setIvTLikes(int ivTLikes) {
        this.ivTLikes = ivTLikes;
    }
}
