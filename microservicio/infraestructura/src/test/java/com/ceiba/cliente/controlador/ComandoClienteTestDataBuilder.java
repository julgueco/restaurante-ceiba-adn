/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.cliente.controlador;

import com.ceiba.restaurante.cliente.comando.ComandoCliente;

/**
 *
 * @author julian.guerrero
 */
public class ComandoClienteTestDataBuilder {

    private String numeroDocumento;
    private String nombre;
    private String celular;
    private String correo;

    public ComandoClienteTestDataBuilder crearPorDefecto() {
        this.numeroDocumento = "123456789";
        this.nombre = "Prueba nombre";
        this.celular = "3133333333";
        this.correo = "pruebacorreo@prueba.com";
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(this.numeroDocumento, this.nombre, this.celular, this.correo);
    }
}
