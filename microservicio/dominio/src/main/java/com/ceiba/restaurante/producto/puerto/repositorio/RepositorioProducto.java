/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceiba.restaurante.producto.puerto.repositorio;

import com.ceiba.restaurante.producto.modelo.entidad.Producto;
import java.util.List;

/**
 *
 * @author julian.guerrero
 */
public interface RepositorioProducto {

    Long guardar(Producto producto);

    Producto obtenerPorId(Integer id);

    List<Producto> obtenerTodos();

    void cambiarPrecio(Producto producto);
}
