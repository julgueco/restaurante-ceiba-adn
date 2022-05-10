/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.consulta;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuestaSinParametros;
import com.ceiba.restaurante.menu.modelo.dto.MenuProductoDTO;
import com.ceiba.restaurante.menu.servicio.ServicioMenuProducto;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorObtenerMenuProductos implements ManejadorComandoRespuestaSinParametros<ComandoRespuesta<List<MenuProductoDTO>>> {

    private final ServicioMenuProducto servicioMenuProducto;

    public ManejadorObtenerMenuProductos(ServicioMenuProducto servicioMenuProducto) {
        this.servicioMenuProducto = servicioMenuProducto;
    }

    @Override
    public ComandoRespuesta<List<MenuProductoDTO>> ejecutar() {
        return new ComandoRespuesta<>(servicioMenuProducto.obtenerTodos());
    }
}
