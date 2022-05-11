/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.restaurante.menu.consulta.MenuCompleto;
import com.ceiba.restaurante.menu.consulta.ManejadorObtenerMenuCompleto;
import com.ceiba.restaurante.menu.consulta.ManejadorObtenerMenuProductos;
import com.ceiba.restaurante.menu.consulta.ManejadorObtenerMenus;
import com.ceiba.restaurante.menu.consulta.ManejadorObtenerMenusActivos;
import com.ceiba.restaurante.menu.modelo.dto.MenuActivoDTO;
import com.ceiba.restaurante.menu.modelo.dto.MenuCompletoDTO;
import com.ceiba.restaurante.menu.modelo.dto.MenuDTO;
import com.ceiba.restaurante.menu.modelo.dto.MenuProductoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julian.guerrero
 */
@RestController
@RequestMapping("/menu")
@Tag(name = "Controlador menu")
public class ConsultaControladorMenu {

    private final ManejadorObtenerMenus manejadorObtenerMenus;
    private final ManejadorObtenerMenusActivos manejadorObtenerMenusActivos;
    private final ManejadorObtenerMenuProductos manejadorObtenerMenuProductos;
    private final ManejadorObtenerMenuCompleto manejadorObtenerMenuCompleto;

    public ConsultaControladorMenu(ManejadorObtenerMenus manejadorObtenerMenus,
            ManejadorObtenerMenusActivos manejadorObtenerMenusActivos,
            ManejadorObtenerMenuProductos manejadorObtenerMenuProductos,
            ManejadorObtenerMenuCompleto manejadorObtenerMenuCompleto) {
        this.manejadorObtenerMenus = manejadorObtenerMenus;
        this.manejadorObtenerMenusActivos = manejadorObtenerMenusActivos;
        this.manejadorObtenerMenuProductos = manejadorObtenerMenuProductos;
        this.manejadorObtenerMenuCompleto = manejadorObtenerMenuCompleto;
    }

    @GetMapping("activo")
    @Operation(summary = "Obtener Menus Activos", description = "Metodo utilizado para consultar los menus activos")
    public ComandoRespuesta<List<MenuActivoDTO>> obtenerActivos() {
        return this.manejadorObtenerMenusActivos.ejecutar();
    }

    @GetMapping
    @Operation(summary = "Obtener Menus", description = "Metodo utilizado para consultar los menus")
    public ComandoRespuesta<List<MenuDTO>> obtener() {
        return this.manejadorObtenerMenus.ejecutar();
    }

    @GetMapping("menuProducto")
    @Operation(summary = "Obtener Relacion Menus Con Productos", description = "Metodo utilizado para consultar la relacion entre menus y productos")
    public ComandoRespuesta<List<MenuProductoDTO>> obtenerMenuProducto() {
        return this.manejadorObtenerMenuProductos.ejecutar();
    }

    @GetMapping("menuCompleto/{idMenu}")
    @Operation(summary = "Obtener Menu Con Productos", description = "Metodo utilizado para consultar un menu con sus productos asociados")
    public ComandoRespuesta<MenuCompletoDTO> obtenerMenuCompleto(@PathVariable("idMenu") Integer idMenu) {
        return this.manejadorObtenerMenuCompleto.ejecutar(new MenuCompleto(idMenu));
    }
}
