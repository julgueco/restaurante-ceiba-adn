/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.producto.modelo.dto;

import com.ceiba.dominio.ValidadorArgumento;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author julian.guerrero
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer id;
    private String nombre;
    private BigDecimal precio;

    public static ProductoDTO crear(Integer id, String nombre, BigDecimal precio) {
        ValidadorArgumento.validarNumerico(id.toString(), "Id es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "Nombre es requerido");
        ValidadorArgumento.validarDecimal(precio.toString(), "Precio es requerido");

        return new ProductoDTO(id, nombre, precio);
    }
}
