/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.pedido.comando;

import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import java.util.List;
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
public class ComandoCalcularGuardarPedido {

    private Integer idCliente;
    private List<ProductoDTO> productos;
}
