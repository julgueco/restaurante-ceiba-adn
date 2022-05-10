/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.consulta;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuestaSinParametros;
import com.ceiba.restaurante.menu.modelo.dto.MenuActivoDTO;
import com.ceiba.restaurante.menu.servicio.ServicioMenu;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorObtenerMenusActivos implements ManejadorComandoRespuestaSinParametros<ComandoRespuesta<List<MenuActivoDTO>>> {

    private final ServicioMenu servicioMenu;

    public ManejadorObtenerMenusActivos(ServicioMenu servicioMenu) {
        this.servicioMenu = servicioMenu;
    }

    @Override
    public ComandoRespuesta<List<MenuActivoDTO>> ejecutar() {
        return new ComandoRespuesta<>(servicioMenu.obtenerActivos());
    }
}
