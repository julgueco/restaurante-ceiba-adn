/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.pedido.controlador;

import com.ceiba.restaurante.pedido.comando.ComandoCalcularGuardarPedido;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julian.guerrero
 */
public class ComandoPedidoTestDataBuilder {

    private Integer idCliente;
    private List<ProductoDTO> productos;

    public ComandoPedidoTestDataBuilder crearPorDefecto() {
        this.idCliente = 1;
        this.productos = this.crearProductos();
        return this;
    }

    private List<ProductoDTO> crearProductos() {
        List<ProductoDTO> productos = new ArrayList<ProductoDTO>();
        productos.add(new ProductoDTO(1, "Papa a la francesa", BigDecimal.valueOf(3000)));
        productos.add(new ProductoDTO(2, "Carne asada", BigDecimal.valueOf(4000)));
        productos.add(new ProductoDTO(3, "Crema de zanahoria", BigDecimal.valueOf(3000)));
        return productos;
    }

    public ComandoCalcularGuardarPedido build() {
        return new ComandoCalcularGuardarPedido(this.idCliente, this.productos);
    }
}
