/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.consulta;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.restaurante.menu.modelo.dto.MenuCompletoDTO;
import com.ceiba.restaurante.menu.servicio.ServicioMenuProducto;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorObtenerMenuCompleto implements ManejadorComandoRespuesta<MenuCompleto, ComandoRespuesta<MenuCompletoDTO>> {

    private final ServicioMenuProducto servicioMenuProducto;

    public ManejadorObtenerMenuCompleto(ServicioMenuProducto servicioMenuProducto) {
        this.servicioMenuProducto = servicioMenuProducto;
    }

    @Override
    public ComandoRespuesta<MenuCompletoDTO> ejecutar(MenuCompleto menuCompleto) {
        return new ComandoRespuesta<>(servicioMenuProducto.obtenerMenuCompletoPorIdMenu(menuCompleto.getId()));
    }
}
