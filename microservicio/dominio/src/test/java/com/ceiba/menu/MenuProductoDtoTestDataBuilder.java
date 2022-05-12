package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.dto.MenuProductoDTO;

public class MenuProductoDtoTestDataBuilder {

    private Integer id;
    private Integer idMenu;
    private Integer idProducto;

    public MenuProductoDtoTestDataBuilder conMenuProductoDtoPorDefecto() {
        this.id = 1;
        this.idMenu = 2;
        this.idProducto = 3;
        return this;
    }

    public MenuProductoDTO crear() {
        return MenuProductoDTO.crear(id, idMenu, idProducto);
    }
}
