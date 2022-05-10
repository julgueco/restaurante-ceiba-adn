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
public class MenuActivoDTO {

    private Integer id;
    private String nombre;

    public static MenuActivoDTO crear(Integer id, String nombre) {
        ValidadorArgumento.validarNumerico(id.toString(), "Id es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "Nombre es requerido");

        return new MenuActivoDTO(id, nombre);
    }
}
