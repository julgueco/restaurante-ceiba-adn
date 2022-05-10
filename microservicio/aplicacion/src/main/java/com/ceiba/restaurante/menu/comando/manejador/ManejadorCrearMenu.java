/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.restaurante.menu.comando.ComandoMenu;
import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import com.ceiba.restaurante.menu.servicio.ServicioMenu;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCrearMenu implements ManejadorComandoRespuesta<ComandoMenu, ComandoRespuesta<Long>> {

    private final ServicioMenu servicioMenu;

    public ManejadorCrearMenu(ServicioMenu servicioMenu) {
        this.servicioMenu = servicioMenu;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoMenu menuRestaurante) {
        return new ComandoRespuesta<>(servicioMenu.guardar(new Menu(menuRestaurante.getNombre(), menuRestaurante.getActivo())));
    }
}
