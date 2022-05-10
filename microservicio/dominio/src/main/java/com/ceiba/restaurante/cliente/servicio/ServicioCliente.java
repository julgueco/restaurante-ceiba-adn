/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.cliente.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;
import com.ceiba.restaurante.cliente.puerto.repositorio.RepositorioCliente;

/**
 *
 * @author julian.guerrero
 */
public class ServicioCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long guardar(Cliente cliente) {
        ValidadorArgumento.validarObligatorio(cliente, "No existe un cliente para crear");
        ValidadorArgumento.validarObligatorio(cliente.getNumeroDocumento(), "No existe un numero de documento para crear cliente");
        ValidadorArgumento.validarObligatorio(cliente.getNombre(), "No existe un nombre para crear cliente");
        ValidadorArgumento.validarObligatorio(cliente.getCelular(), "No existe un numero de celular para crear cliente");
        ValidadorArgumento.validarLongitud(cliente.getCelular(), 10, "El numero de celular del cliente no tiene una longitud valida");
        ValidadorArgumento.validarObligatorio(cliente.getCorreo(), "No existe un correo para crear cliente");
        ValidadorArgumento.validarRegex(cliente.getCorreo(), "^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.([a-zA-Z]{2,4}))|([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.([a-zA-Z]{2,4})+\\.([a-zA-Z]{2,4}))", "El correo del cliente no tiene un formato valido");
        ValidadorArgumento.validarNumerico(cliente.getCantidadDias().toString(), "No existe una cantidad de dias para crear cliente");

        if (this.obtenerPorNumeroDocumento(cliente.getNumeroDocumento()) != null) {
            throw new ExcepcionDuplicidad("Cliente ya existe");
        }

        return repositorioCliente.guardar(cliente);
    }

    private Cliente obtenerPorNumeroDocumento(String numeroDocumento) {
        return repositorioCliente.obtenerPorNumeroDocumento(numeroDocumento);
    }
}
