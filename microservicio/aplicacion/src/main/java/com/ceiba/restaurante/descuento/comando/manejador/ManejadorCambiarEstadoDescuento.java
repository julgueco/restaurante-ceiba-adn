/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.descuento.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.restaurante.descuento.comando.ComandoCambiarEstadoDescuento;
import com.ceiba.restaurante.descuento.servicio.ServicioDescuento;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCambiarEstadoDescuento implements ManejadorComando<ComandoCambiarEstadoDescuento> {

    private final ServicioDescuento servicioDescuento;

    public ManejadorCambiarEstadoDescuento(ServicioDescuento servicioDescuento) {
        this.servicioDescuento = servicioDescuento;
    }

    @Override
    public void ejecutar(ComandoCambiarEstadoDescuento cambiarEstadoDescuento) {
        servicioDescuento.cambiarEstado(cambiarEstadoDescuento.getId());
    }
}
