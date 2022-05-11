/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.pedido.modelo.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author julian.guerrero
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PedidoDTO {

    private Integer id;
    private BigDecimal precioTotal;
}
