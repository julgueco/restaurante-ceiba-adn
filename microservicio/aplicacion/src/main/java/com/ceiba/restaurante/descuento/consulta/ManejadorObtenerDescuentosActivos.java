/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.descuento.consulta;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuestaSinParametros;
import com.ceiba.restaurante.descuento.servicio.ServicioDescuento;
import com.ceiba.restaurante.descuento.modelo.dto.DescuentoActivoDTO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorObtenerDescuentosActivos implements ManejadorComandoRespuestaSinParametros<ComandoRespuesta<List<DescuentoActivoDTO>>> {

    private final ServicioDescuento servicioDescuento;

    public ManejadorObtenerDescuentosActivos(ServicioDescuento servicioDescuento) {
        this.servicioDescuento = servicioDescuento;
    }

    @Override
    public ComandoRespuesta<List<DescuentoActivoDTO>> ejecutar() {
        return new ComandoRespuesta<>(servicioDescuento.obtenerActivos());
    }
}
