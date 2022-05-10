/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.modelo.entidad;

/**
 *
 * @author julian.guerrero
 */
public class MenuProducto {

    private Integer id;
    private Integer idMenu;
    private Integer idProducto;

    public MenuProducto(Integer id, Integer idMenu, Integer idProducto) {
        this.id = id;
        this.idMenu = idMenu;
        this.idProducto = idProducto;
    }

    public MenuProducto(Integer idMenu, Integer idProducto) {
        this.idMenu = idMenu;
        this.idProducto = idProducto;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public Integer getIdProducto() {
        return idProducto;
    }
}
