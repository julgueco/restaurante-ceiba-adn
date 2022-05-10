/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.descuento.modelo.entidad;

/**
 *
 * @author julian.guerrero
 */
public class Descuento {

    private Integer id;
    private Integer cantidadDias;
    private Boolean activo;
    private Integer porcentaje;

    public Descuento(Integer id, Integer cantidadDias, Integer porcentaje, Boolean activo) {
        this.id = id;
        this.cantidadDias = cantidadDias;
        this.porcentaje = porcentaje;
        this.activo = activo;
    }

    public Descuento(Integer cantidadDias, Integer porcentaje, Boolean activo) {
        this.cantidadDias = cantidadDias;
        this.porcentaje = porcentaje;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCantidadDias() {
        return cantidadDias;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void cambiarEstado() {
        this.activo = !this.activo;
    }
}
