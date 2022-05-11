/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.producto.controlador;

import com.ceiba.restaurante.producto.comando.ComandoProducto;
import java.math.BigDecimal;

/**
 *
 * @author julian.guerrero
 */
public class ComandoProductoTestDataBuilder {

    private String nombre;
    private BigDecimal precio;

    public ComandoProductoTestDataBuilder crearPorDefecto() {
        this.nombre = "Jugo de mora";
        this.precio = BigDecimal.valueOf(2000);
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(this.nombre, this.precio);
    }
}
