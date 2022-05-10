/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceiba.restaurante.pedido.puerto.repositorio;

import com.ceiba.restaurante.pedido.modelo.entidad.Pedido;

/**
 *
 * @author julian.guerrero
 */
public interface RepositorioPedido {

    Integer guardar(Pedido pedido);

    Pedido obtenerPorId(Integer id);
}
