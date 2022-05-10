/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ceiba.restaurante.cliente.puerto.repositorio;

import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;

/**
 *
 * @author julian.guerrero
 */
public interface RepositorioCliente {

    Long guardar(Cliente cliente);

    Cliente obtenerPorId(Integer id);

    Cliente obtenerPorNumeroDocumento(String numeroDocumento);

    void actualizarCantidadDias(Cliente cliente);
}
