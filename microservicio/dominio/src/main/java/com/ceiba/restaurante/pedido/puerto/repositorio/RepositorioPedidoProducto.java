/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceiba.restaurante.pedido.puerto.repositorio;

import com.ceiba.restaurante.pedido.modelo.entidad.PedidoProducto;

/**
 *
 * @author julian.guerrero
 */
public interface RepositorioPedidoProducto {

    long guardar(PedidoProducto pedidoProducto);

    PedidoProducto obtenerPorId(Integer id);
}
