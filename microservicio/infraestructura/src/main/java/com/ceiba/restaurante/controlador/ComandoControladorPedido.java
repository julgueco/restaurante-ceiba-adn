/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.restaurante.pedido.comando.ComandoCalcularGuardarPedido;
import com.ceiba.restaurante.pedido.comando.manejador.ManejadorCalcularGuardarPedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.math.BigDecimal;
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
@RequestMapping("/pedido")
@Tag(name = "Controlador pedido")
public class ComandoControladorPedido {

    private final ManejadorCalcularGuardarPedido manejadorCalcularGuardarPedido;

    public ComandoControladorPedido(ManejadorCalcularGuardarPedido manejadorCalcularGuardarPedido) {
        this.manejadorCalcularGuardarPedido = manejadorCalcularGuardarPedido;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear Pedido", description = "Metodo utilizado para crear un pedido y retornar el precio")
    public ComandoRespuesta<BigDecimal> crear(@RequestBody ComandoCalcularGuardarPedido calcularGuardarPedido) {
        return this.manejadorCalcularGuardarPedido.ejecutar(calcularGuardarPedido);
    }
}
