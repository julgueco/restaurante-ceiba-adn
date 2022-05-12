package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.entidad.MenuProducto;

public class MenuProductoTestDataBuilder {

    private Integer id;
    private Integer idMenu;
    private Integer idProducto;

    public MenuProductoTestDataBuilder conMenuProductoPorDefecto() {
        this.id = 1;
        this.idMenu = 2;
        this.idProducto = 3;
        return this;
    }

    public MenuProducto reconstruir() {
        return new MenuProducto(id, idMenu, idProducto);
    }

    public MenuProducto reconstruirSinId() {
        return new MenuProducto(idMenu, idProducto);
    }
}
