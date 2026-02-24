package com.example.appnasa;

import com.google.gson.annotations.SerializedName;

public class Apod {

    @SerializedName("title")
    private String titulo;

    @SerializedName("date")
    private String fecha;

    @SerializedName("explanation")
    private String explicacion;

    @SerializedName("url")
    private String urlImagen;

    public String getTitulo() { return titulo; }
    public String getFecha() { return fecha; }
    public String getExplicacion() { return explicacion; }
    public String getUrlImagen() { return urlImagen; }
}