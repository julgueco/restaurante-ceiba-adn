/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.producto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.restaurante.producto.modelo.entidad.Producto;
import com.ceiba.restaurante.producto.comando.ComandoProducto;
import com.ceiba.restaurante.producto.servicio.ServicioProducto;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCrearProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<Long>> {

    private final ServicioProducto servicioProducto;

    public ManejadorCrearProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoProducto productoRestaurante) {
        return new ComandoRespuesta<>(servicioProducto.guardar(new Producto(productoRestaurante.getNombre(), productoRestaurante.getPrecio())));
    }
}
