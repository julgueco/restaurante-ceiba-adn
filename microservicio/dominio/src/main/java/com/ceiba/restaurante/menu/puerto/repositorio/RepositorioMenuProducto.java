/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceiba.restaurante.menu.puerto.repositorio;

import com.ceiba.restaurante.menu.modelo.entidad.MenuProducto;
import java.util.List;

/**
 *
 * @author julian.guerrero
 */
public interface RepositorioMenuProducto {

    Long guardar(MenuProducto menuProducto);

    List<MenuProducto> obtenerPorIdMenu(Integer idMenu);

    List<MenuProducto> obtenerTodos();
}
