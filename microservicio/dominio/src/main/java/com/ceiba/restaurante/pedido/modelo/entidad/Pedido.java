/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.pedido.modelo.entidad;

import java.math.BigDecimal;

/**
 *
 * @author julian.guerrero
 */
public class Pedido {

    private Integer id;
    private Integer idCliente;
    private Integer idDescuento;
    private BigDecimal precioTotal;
    private Boolean precioBase;

    public Pedido(Integer id, Integer idCliente, Integer idDescuento, BigDecimal precioTotal, Boolean precioBase) {
        this.id = id;
        this.idCliente = idCliente;
        this.idDescuento = idDescuento;
        this.precioTotal = precioTotal;
        this.precioBase = precioBase;
    }

    public Pedido(Integer idCliente, BigDecimal precioTotal, Boolean precioBase) {
        this.idCliente = idCliente;
        this.precioTotal = precioTotal;
        this.precioBase = precioBase;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public Boolean getPrecioBase() {
        return precioBase;
    }

    public Integer getIdDescuento() {
        return idDescuento;
    }

    public void agregarDescuento(Integer idDescuento, Integer porcentajeAplicar) {
        this.idDescuento = idDescuento;
        float porcentaje = Float.parseFloat(porcentajeAplicar.toString()) / 100;
        float precio = Float.parseFloat(this.precioTotal.toString());
        precio = precio - (precio * porcentaje);
        this.precioTotal = BigDecimal.valueOf(precio);
    }
}
