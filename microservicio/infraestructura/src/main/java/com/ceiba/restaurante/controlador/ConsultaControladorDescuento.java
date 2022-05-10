/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.restaurante.descuento.consulta.ManejadorObtenerDescuentosActivos;
import com.ceiba.restaurante.descuento.modelo.dto.DescuentoActivoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julian.guerrero
 */
@RestController
@RequestMapping("/descuento")
@Tag(name = "Controlador descuento")
public class ConsultaControladorDescuento {

    private final ManejadorObtenerDescuentosActivos manejadorObtenerDescuentoActivos;

    public ConsultaControladorDescuento(ManejadorObtenerDescuentosActivos manejadorObtenerDescuentoActivos) {
        this.manejadorObtenerDescuentoActivos = manejadorObtenerDescuentoActivos;
    }

    @GetMapping("activo")
    @Operation(summary = "Obtener Descuentos Activos", description = "Metodo utilizado para consultar los descuentos activos")
    public ComandoRespuesta<List<DescuentoActivoDTO>> obtenerAactivos() {
        return this.manejadorObtenerDescuentoActivos.ejecutar();
    }
}
