/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.modelo.dto;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author julian.guerrero
 */
@AllArgsConstructor
@Getter
public class MenuProductoDTO {

    private Integer id;
    private Integer idMenu;
    private Integer idProducto;

    public static MenuProductoDTO crear(Integer id, Integer idMenu, Integer idProducto) {
        ValidadorArgumento.validarNumerico(id.toString(), "Id es requerido");
        ValidadorArgumento.validarNumerico(idMenu.toString(), "Id menu es requerido");
        ValidadorArgumento.validarNumerico(idProducto.toString(), "Id producto es requerido");

        return new MenuProductoDTO(id, idMenu, idProducto);
    }
}
