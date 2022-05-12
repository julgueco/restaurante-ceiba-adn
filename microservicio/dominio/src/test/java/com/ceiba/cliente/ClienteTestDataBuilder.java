package com.ceiba.cliente;

import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

    private Integer id;
    private String numeroDocumento;
    private String nombre;
    private String celular;
    private String correo;
    private Integer cantidadDias;

    public ClienteTestDataBuilder conClientePorDefecto() {
        this.id = 1;
        this.numeroDocumento = "123456789";
        this.nombre = "Prueba nombre";
        this.celular = "3133333333";
        this.correo = "pruebacorreo@prueba.com";
        this.cantidadDias = 0;
        return this;
    }

    public Cliente reconstruir() {
        return new Cliente(id, numeroDocumento, nombre, celular, correo, cantidadDias);
    }

    public Cliente reconstruirSinId() {
        return new Cliente(numeroDocumento, nombre, celular, correo, cantidadDias);
    }
}
