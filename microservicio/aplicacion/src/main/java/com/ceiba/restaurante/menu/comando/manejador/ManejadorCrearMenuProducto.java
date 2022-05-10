/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.restaurante.menu.comando.ComandoMenuProducto;
import com.ceiba.restaurante.menu.modelo.entidad.MenuProducto;
import com.ceiba.restaurante.menu.servicio.ServicioMenuProducto;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCrearMenuProducto implements ManejadorComandoRespuesta<ComandoMenuProducto, ComandoRespuesta<Long>> {

    private final ServicioMenuProducto servicioMenuProducto;

    public ManejadorCrearMenuProducto(ServicioMenuProducto servicioMenuProducto) {
        this.servicioMenuProducto = servicioMenuProducto;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoMenuProducto menuProductoRestaurante) {
        return new ComandoRespuesta<>(servicioMenuProducto.guardar(new MenuProducto(menuProductoRestaurante.getIdMenu(), menuProductoRestaurante.getIdProducto())));
    }
}
