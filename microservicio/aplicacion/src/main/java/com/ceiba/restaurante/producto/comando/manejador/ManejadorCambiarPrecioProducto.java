/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.producto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.restaurante.producto.comando.ComandoCambiarPrecioProducto;
import com.ceiba.restaurante.producto.servicio.ServicioProducto;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCambiarPrecioProducto implements ManejadorComando<ComandoCambiarPrecioProducto> {

    private final ServicioProducto servicioProducto;

    public ManejadorCambiarPrecioProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    @Override
    public void ejecutar(ComandoCambiarPrecioProducto cambiarPrecioProducto) {
        servicioProducto.cambiarPrecio(cambiarPrecioProducto.getId(), cambiarPrecioProducto.getPrecio());
    }
}
