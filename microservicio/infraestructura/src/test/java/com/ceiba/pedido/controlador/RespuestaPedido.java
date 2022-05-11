package com.ceiba.pedido.controlador;

import com.ceiba.restaurante.pedido.modelo.dto.PedidoDTO;

public class RespuestaPedido {

    private PedidoDTO valor;

    public RespuestaPedido() {
    }

    public RespuestaPedido(PedidoDTO valor) {
        this.valor = valor;
    }

    public PedidoDTO getValor() {
        return valor;
    }
}
