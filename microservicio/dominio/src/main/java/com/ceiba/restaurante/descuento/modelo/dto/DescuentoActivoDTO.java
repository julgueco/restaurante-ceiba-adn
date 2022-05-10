/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.descuento.modelo.dto;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author julian.guerrero
 */
@AllArgsConstructor
@Getter
public class DescuentoActivoDTO {

    private Integer id;
    private Integer cantidadDias;
    private Integer porcentaje;

    public static DescuentoActivoDTO crear(Integer id, Integer cantidadDias, Integer porcentaje) {
        ValidadorArgumento.validarObligatorio(id, "Id es requerido");
        ValidadorArgumento.validarObligatorio(cantidadDias, "Cantidad dias es requerido");
        ValidadorArgumento.validarObligatorio(porcentaje, "Porcentaje es requerido");
        return new DescuentoActivoDTO(id, cantidadDias, porcentaje);
    }
}
