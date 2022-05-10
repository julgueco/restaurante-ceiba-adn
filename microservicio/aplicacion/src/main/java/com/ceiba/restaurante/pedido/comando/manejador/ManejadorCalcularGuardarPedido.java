/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.restaurante.pedido.comando.ComandoCalcularGuardarPedido;
import com.ceiba.restaurante.pedido.servicio.ServicioPedido;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 *
 * @author julian.guerrero
 */
@Component
public class ManejadorCalcularGuardarPedido implements ManejadorComandoRespuesta<ComandoCalcularGuardarPedido, ComandoRespuesta<BigDecimal>> {

    private final ServicioPedido servicioPedido;

    public ManejadorCalcularGuardarPedido(ServicioPedido servicioPedido) {
        this.servicioPedido = servicioPedido;
    }

    @Override
    public ComandoRespuesta<BigDecimal> ejecutar(ComandoCalcularGuardarPedido calcularGuardarPedido) {
        return new ComandoRespuesta<>(servicioPedido.calcularGuardarPedido(calcularGuardarPedido.getIdCliente(), calcularGuardarPedido.getProductos()));
    }
}
