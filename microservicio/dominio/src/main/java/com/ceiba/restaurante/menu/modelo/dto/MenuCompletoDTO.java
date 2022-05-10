/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.modelo.dto;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author julian.guerrero
 */
@AllArgsConstructor
@Getter
public class MenuCompletoDTO {

    private Integer id;
    private String nombre;
    private Boolean activo;
    private List<ProductoDTO> productos;

    public static MenuCompletoDTO crear(Integer id, String nombre, Boolean activo, List<ProductoDTO> productos) {
        ValidadorArgumento.validarNumerico(id.toString(), "Id es requerida");
        ValidadorArgumento.validarObligatorio(nombre, "Nombre es requeridO");
        ValidadorArgumento.validarObligatorio(productos, "Los productos son requeridos");
        ValidadorArgumento.validarNoVacio(productos, "Los productos son requeridos");

        return new MenuCompletoDTO(id, nombre, activo, productos);
    }
}
