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
public class MenuDTO {

    private Integer id;
    private String nombre;
    private Boolean activo;

    public static MenuDTO crear(Integer id, String nombre, Boolean activo) {
        ValidadorArgumento.validarNumerico(id.toString(), "Id es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "Nombre es requerido");

        return new MenuDTO(id, nombre, activo);
    }
}
