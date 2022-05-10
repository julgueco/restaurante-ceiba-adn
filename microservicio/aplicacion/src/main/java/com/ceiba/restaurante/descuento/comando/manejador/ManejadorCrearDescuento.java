/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.descuento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.restaurante.descuento.comando.ComandoDescuento;
import com.ceiba.restaurante.descuento.servicio.ServicioDescuento;
import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCrearDescuento implements ManejadorComandoRespuesta<ComandoDescuento, ComandoRespuesta<Long>> {

    private final ServicioDescuento servicioCrearDescuento;

    public ManejadorCrearDescuento(ServicioDescuento servicioCrearDescuento) {
        this.servicioCrearDescuento = servicioCrearDescuento;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoDescuento descuentoRestaurante) {
        return new ComandoRespuesta<>(servicioCrearDescuento.guardar(new Descuento(descuentoRestaurante.getCantidadDias(),descuentoRestaurante.getPorcentaje() , descuentoRestaurante.getActivo())));
    }
}
