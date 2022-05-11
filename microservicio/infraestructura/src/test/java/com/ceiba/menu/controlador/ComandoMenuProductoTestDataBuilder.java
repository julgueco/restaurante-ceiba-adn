/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.menu.controlador;

import com.ceiba.restaurante.menu.comando.ComandoMenuProducto;

/**
 *
 * @author julian.guerrero
 */
public class ComandoMenuProductoTestDataBuilder {

    private Integer idMenu;
    private Integer idProducto;

    public ComandoMenuProductoTestDataBuilder crearPorDefecto() {
        this.idMenu = 2;
        this.idProducto = 1;
        return this;
    }

    public ComandoMenuProducto build() {
        return new ComandoMenuProducto(this.idMenu, this.idProducto);
    }
}
