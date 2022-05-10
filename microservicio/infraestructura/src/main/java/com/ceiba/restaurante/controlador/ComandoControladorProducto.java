/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.restaurante.producto.comando.ComandoCambiarPrecioProducto;
import com.ceiba.restaurante.producto.comando.ComandoProducto;
import com.ceiba.restaurante.producto.comando.manejador.ManejadorCambiarPrecioProducto;
import com.ceiba.restaurante.producto.comando.manejador.ManejadorCrearProducto;
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
@RequestMapping("/producto")
@Tag(name = "Controlador producto")
public class ComandoControladorProducto {

    private final ManejadorCambiarPrecioProducto manejadorCambiarPrecioProducto;
    private final ManejadorCrearProducto manejadorCrearProducto;

    public ComandoControladorProducto(ManejadorCambiarPrecioProducto manejadorCambiarPrecioProducto,
            ManejadorCrearProducto manejadorCrearProducto) {
        this.manejadorCambiarPrecioProducto = manejadorCambiarPrecioProducto;
        this.manejadorCrearProducto = manejadorCrearProducto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear", description = "Metodo utilizado para crear un nuevo producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto productoRestaurante) {
        return this.manejadorCrearProducto.ejecutar(productoRestaurante);
    }

    @PostMapping("cambiarPrecio")
    @Operation(summary = "Cambiar Precio", description = "Metodo utilizado para cambiar el precio de un producto")
    public void cambiar(@RequestBody ComandoCambiarPrecioProducto cambiarPrecioProducto) {
        this.manejadorCambiarPrecioProducto.ejecutar(cambiarPrecioProducto);
    }
}
