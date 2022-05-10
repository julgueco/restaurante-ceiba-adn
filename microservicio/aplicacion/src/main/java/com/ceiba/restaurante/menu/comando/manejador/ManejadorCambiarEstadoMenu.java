/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.restaurante.descuento.comando.ComandoCambiarEstadoDescuento;
import com.ceiba.restaurante.menu.comando.ComandoCambiarEstadoMenu;
import com.ceiba.restaurante.descuento.servicio.ServicioDescuento;
import com.ceiba.restaurante.menu.servicio.ServicioMenu;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCambiarEstadoMenu implements ManejadorComando<ComandoCambiarEstadoMenu> {

    private final ServicioMenu servicioMenu;

    public ManejadorCambiarEstadoMenu(ServicioMenu servicioMenu) {
        this.servicioMenu = servicioMenu;
    }

    @Override
    public void ejecutar(ComandoCambiarEstadoMenu cambiarEstadoMenu) {
        servicioMenu.cambiarEstado(cambiarEstadoMenu.getId());
    }
}
