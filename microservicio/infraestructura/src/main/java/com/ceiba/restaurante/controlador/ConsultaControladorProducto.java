/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import com.ceiba.restaurante.producto.consulta.ManejadorObtenerProductos;
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
@RequestMapping("/producto")
@Tag(name = "Controlador producto")
public class ConsultaControladorProducto {

    private final ManejadorObtenerProductos manejadorObtenerProductos;

    public ConsultaControladorProducto(ManejadorObtenerProductos manejadorObtenerProductos) {
        this.manejadorObtenerProductos = manejadorObtenerProductos;
    }

    @GetMapping
    @Operation(summary = "Obtener Productos", description = "Metodo utilizado para consultar los productos")
    public ComandoRespuesta<List<ProductoDTO>> obtener() {
        return this.manejadorObtenerProductos.ejecutar();
    }
}
