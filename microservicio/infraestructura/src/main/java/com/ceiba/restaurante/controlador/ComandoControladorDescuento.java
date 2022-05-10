/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.restaurante.descuento.comando.ComandoCambiarEstadoDescuento;
import com.ceiba.restaurante.descuento.comando.ComandoDescuento;
import com.ceiba.restaurante.descuento.comando.manejador.ManejadorCambiarEstadoDescuento;
import com.ceiba.restaurante.descuento.comando.manejador.ManejadorCrearDescuento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/descuento")
@Tag(name = "Controlador descuento")
public class ComandoControladorDescuento {

    private final ManejadorCrearDescuento manejadorCrearDescuento;
    private final ManejadorCambiarEstadoDescuento manejadorCambiarEstadoDescuento;

    public ComandoControladorDescuento(ManejadorCrearDescuento manejadorCrearDescuento, ManejadorCambiarEstadoDescuento manejadorCambiarEstadoDescuento) {
        this.manejadorCrearDescuento = manejadorCrearDescuento;
        this.manejadorCambiarEstadoDescuento = manejadorCambiarEstadoDescuento;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear", description = "Metodo utilizado para crear un nuevo descuento")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDescuento descuentoRestaurante) {
        return this.manejadorCrearDescuento.ejecutar(descuentoRestaurante);
    }

    @PostMapping("cambiarEstado/{id}")
    @Operation(summary = "Cambiar Estado", description = "Metodo utilizado para cambiar el estado de un descuento")
    public void cambiar(@PathVariable("id") Integer id) {
        this.manejadorCambiarEstadoDescuento.ejecutar(new ComandoCambiarEstadoDescuento(id));
    }
}
