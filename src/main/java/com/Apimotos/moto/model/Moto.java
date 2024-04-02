package com.Apimotos.moto.model;

public class Moto {
    private Long codigo;
    private String placa;
    private String marca;
    private String nombre;

    public Moto() {
    }
    
    public Moto(Long codigo, String placa, String marca, String nombre) {
        this.codigo = codigo;
        this.placa = placa;
        this.marca = marca;
        this.nombre = nombre;
    }
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    

   
}
