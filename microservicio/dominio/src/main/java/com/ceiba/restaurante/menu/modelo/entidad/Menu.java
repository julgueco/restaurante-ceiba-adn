/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.modelo.entidad;

/**
 *
 * @author julian.guerrero
 */
public class Menu {

    private Integer id;
    private String nombre;
    private Boolean activo;

    public Menu(Integer id, String nombre, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Menu(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void cambiarEstado() {
        this.activo = !this.activo;
    }
}
