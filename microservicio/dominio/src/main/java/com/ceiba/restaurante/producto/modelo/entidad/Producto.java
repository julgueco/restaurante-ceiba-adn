/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.producto.modelo.entidad;

import java.math.BigDecimal;

/**
 *
 * @author julian.guerrero
 */
public class Producto {

    private Integer id;
    private String nombre;
    private BigDecimal precio;

    public Producto(Integer id, String nombre, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void cambiarPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
