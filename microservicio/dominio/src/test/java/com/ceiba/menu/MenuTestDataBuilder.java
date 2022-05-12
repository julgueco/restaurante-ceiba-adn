package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.entidad.Menu;

public class MenuTestDataBuilder {

    private Integer id;
    private String nombre;
    private Boolean activo;

    public MenuTestDataBuilder conMenuPorDefecto() {
        this.id = 1;
        this.nombre = "Menu lunes";
        this.activo = false;
        return this;
    }

    public Menu reconstruir() {
        return new Menu(id, nombre, activo);
    }

    public Menu reconstruirSinId() {
        return new Menu(nombre, activo);
    }
}
