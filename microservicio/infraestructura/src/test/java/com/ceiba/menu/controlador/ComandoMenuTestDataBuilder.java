/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.menu.controlador;

import com.ceiba.restaurante.menu.comando.ComandoMenu;

/**
 *
 * @author julian.guerrero
 */
public class ComandoMenuTestDataBuilder {

    private String nombre;
    private Boolean activo;

    public ComandoMenuTestDataBuilder crearPorDefecto() {
        this.nombre = "Menu martes";
        this.activo = false;
        return this;
    }

    public ComandoMenu build() {
        return new ComandoMenu(this.nombre, this.activo);
    }
}
