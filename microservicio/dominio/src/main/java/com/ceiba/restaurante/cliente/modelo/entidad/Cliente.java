/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.cliente.modelo.entidad;

/**
 *
 * @author julian.guerrero
 */
public class Cliente {

    private Integer id;
    private String numeroDocumento;
    private String nombre;
    private String celular;
    private String correo;
    private Integer cantidadDias;

    public Cliente(Integer id, String numeroDocumento, String nombre, String celular, String correo, Integer cantidadDias) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.cantidadDias = cantidadDias;
    }

    public Cliente(String numeroDocumento, String nombre, String celular, String correo, Integer cantidadDias) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.cantidadDias = cantidadDias;
    }

    public Integer getId() {
        return id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public Integer getCantidadDias() {
        return cantidadDias;
    }

    public void sumarDia() {
        this.cantidadDias = this.cantidadDias + 1;
    }
    
     public void reiniciarCantidadDias() {
        this.cantidadDias = 0;
    }
}
