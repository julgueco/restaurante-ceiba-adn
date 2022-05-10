/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.producto.consulta;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuestaSinParametros;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import com.ceiba.restaurante.producto.servicio.ServicioProducto;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorObtenerProductos implements ManejadorComandoRespuestaSinParametros<ComandoRespuesta<List<ProductoDTO>>> {

    private final ServicioProducto servicioProducto;

    public ManejadorObtenerProductos(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    @Override
    public ComandoRespuesta<List<ProductoDTO>> ejecutar() {
        return new ComandoRespuesta<>(servicioProducto.obtenerTodos());
    }
}
