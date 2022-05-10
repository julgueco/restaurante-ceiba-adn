/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.cliente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.restaurante.cliente.comando.ComandoCliente;
import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;
import com.ceiba.restaurante.cliente.servicio.ServicioCliente;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta<Long>> {

    private final ServicioCliente servicioCliente;

    public ManejadorCrearCliente(ServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCliente clienteRestaurante) {
        return new ComandoRespuesta<>(servicioCliente.guardar(new Cliente(clienteRestaurante.getNumeroDocumento(), clienteRestaurante.getNombre(), clienteRestaurante.getCelular(), clienteRestaurante.getCorreo(), 0)));
    }
}
