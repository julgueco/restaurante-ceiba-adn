/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.producto.controlador;

import com.ceiba.restaurante.producto.comando.ComandoCambiarPrecioProducto;
import java.math.BigDecimal;

/**
 *
 * @author julian.guerrero
 */
public class ComandoCambiarPrecioProductoTestDataBuilder {

    private Integer id;
    private BigDecimal precio;

    public ComandoCambiarPrecioProductoTestDataBuilder crearPorDefecto() {
        this.id = 1;
        this.precio = BigDecimal.valueOf(2000);
        return this;
    }

    public ComandoCambiarPrecioProducto build() {
        return new ComandoCambiarPrecioProducto(this.id, this.precio);
    }
}
