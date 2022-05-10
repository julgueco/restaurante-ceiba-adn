/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.consulta;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuestaSinParametros;
import com.ceiba.restaurante.menu.modelo.dto.MenuDTO;
import com.ceiba.restaurante.menu.servicio.ServicioMenu;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorObtenerMenus implements ManejadorComandoRespuestaSinParametros<ComandoRespuesta<List<MenuDTO>>> {

    private final ServicioMenu servicioMenu;

    public ManejadorObtenerMenus(ServicioMenu servicioMenu) {
        this.servicioMenu = servicioMenu;
    }

    @Override
    public ComandoRespuesta<List<MenuDTO>> ejecutar() {
        return new ComandoRespuesta<>(servicioMenu.obtenerTodos());
    }
}
