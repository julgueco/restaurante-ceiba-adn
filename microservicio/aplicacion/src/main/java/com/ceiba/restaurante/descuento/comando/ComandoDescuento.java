/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.descuento.comando;

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
public class ComandoDescuento {
    private Integer cantidadDias;
    private Boolean activo;
    private Integer porcentaje;
}
