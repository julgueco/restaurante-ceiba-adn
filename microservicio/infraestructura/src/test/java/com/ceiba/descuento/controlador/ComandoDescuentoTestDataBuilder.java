/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.descuento.controlador;

import com.ceiba.restaurante.descuento.comando.ComandoDescuento;

/**
 *
 * @author julian.guerrero
 */
public class ComandoDescuentoTestDataBuilder {

    private Integer cantidadDias;
    private Boolean activo;
    private Integer porcentaje;

    public ComandoDescuentoTestDataBuilder crearPorDefecto() {
        this.cantidadDias = 7;
        this.activo = false;
        this.porcentaje = 20;
        return this;
    }

    public ComandoDescuento build() {
        return new ComandoDescuento(this.cantidadDias, this.activo, this.porcentaje);
    }
}
