/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.producto.comando;

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
public class ComandoCambiarPrecioProducto {

    private Integer id;
    private BigDecimal precio;
}
