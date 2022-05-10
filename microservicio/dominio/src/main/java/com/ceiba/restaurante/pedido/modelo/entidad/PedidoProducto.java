/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.pedido.modelo.entidad;

/**
 *
 * @author julian.guerrero
 */
public class PedidoProducto {

    private Integer id;
    private Integer idPedido;
    private Integer idProducto;

    public PedidoProducto(Integer id, Integer idPedido, Integer idProducto) {
        this.id = id;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public PedidoProducto(Integer idPedido, Integer idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }
}
