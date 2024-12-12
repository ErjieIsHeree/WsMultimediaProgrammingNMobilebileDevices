package com.example.meetdevs;

public class Item {
    private int id_imagen;
    private boolean isFavorito;
    private String titulo;
    private String texto;

    public Item(int id_imagen, boolean isFavorito, String titulo, String texto) {
        this.id_imagen = id_imagen;
        this.isFavorito = isFavorito;
        this.titulo = titulo;
        this.texto = texto;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setFavorito(boolean favorito) {
        isFavorito = favorito;
    }

    public boolean isFavorito() {
        return isFavorito;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

}
