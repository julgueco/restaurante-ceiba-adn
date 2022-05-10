/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.restaurante.menu.comando.ComandoCambiarEstadoMenu;
import com.ceiba.restaurante.menu.comando.ComandoMenuProducto;
import com.ceiba.restaurante.menu.comando.ComandoMenu;
import com.ceiba.restaurante.menu.comando.manejador.ManejadorCambiarEstadoMenu;
import com.ceiba.restaurante.menu.comando.manejador.ManejadorCrearMenu;
import com.ceiba.restaurante.menu.comando.manejador.ManejadorCrearMenuProducto;
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
@RequestMapping("/menu")
@Tag(name = "Controlador menu")
public class ComandoControladorMenu {

    private final ManejadorCrearMenu manejadorCrearMenu;
    private final ManejadorCambiarEstadoMenu manejadorCambiarEstadoMenu;
    private final ManejadorCrearMenuProducto manejadorCrearMenuProducto;

    public ComandoControladorMenu(ManejadorCrearMenu manejadorCrearMenu,
            ManejadorCambiarEstadoMenu manejadorCambiarEstadoMenu,
            ManejadorCrearMenuProducto manejadorCrearMenuProducto) {
        this.manejadorCrearMenu = manejadorCrearMenu;
        this.manejadorCambiarEstadoMenu = manejadorCambiarEstadoMenu;
        this.manejadorCrearMenuProducto = manejadorCrearMenuProducto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear", description = "Metodo utilizado para crear un nuevo menu")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMenu menuRestaurante) {
        return this.manejadorCrearMenu.ejecutar(menuRestaurante);
    }

    @PostMapping("cambiarEstado/{id}")
    @Operation(summary = "Cambiar Estado", description = "Metodo utilizado para cambiar el estado de un menu")
    public void cambiar(@PathVariable("id") Integer id) {
        this.manejadorCambiarEstadoMenu.ejecutar(new ComandoCambiarEstadoMenu(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("menuProducto")
    @Operation(summary = "Crear", description = "Metodo utilizado para crear una relacion nueva entre un menu y un producto")
    public ComandoRespuesta<Long> crearMenuProducto(@RequestBody ComandoMenuProducto menuProductoRestaurante) {
        return this.manejadorCrearMenuProducto.ejecutar(menuProductoRestaurante);
    }
}