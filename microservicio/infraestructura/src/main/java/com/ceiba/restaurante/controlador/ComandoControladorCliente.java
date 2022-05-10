/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.restaurante.cliente.comando.ComandoCliente;
import com.ceiba.restaurante.cliente.comando.manejador.ManejadorCrearCliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julian.guerrero
 */
@RestController
@RequestMapping("/cliente")
@Tag(name = "Controlador cliente")
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;

    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear", description = "Metodo utilizado para crear un cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente clienteRestaurante) {
        return this.manejadorCrearCliente.ejecutar(clienteRestaurante);
    }
}
