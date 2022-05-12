/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceiba.restaurante.descuento.puerto.repositorio;

import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import java.util.List;

/**
 *
 * @author julian.guerrero
 */
public interface RepositorioDescuento {
    Long guardar(Descuento descuento);
    List<Descuento> obtenerActivos();
    Integer cambiarEstado(Descuento descuento);
    Descuento obtenerPorId(Integer id);
}
