/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceiba.restaurante.menu.puerto.repositorio;

import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import java.util.List;

/**
 *
 * @author julian.guerrero
 */
public interface RepositorioMenu {
    Long guardar(Menu menu);
    List<Menu> obtenerActivos();
    List<Menu> obtenerTodos();
    Integer cambiarEstado(Menu menu);
    Menu obtenerPorId(Integer id);
}
