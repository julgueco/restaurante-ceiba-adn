package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.dto.MenuDTO;

public class MenuDtoTestDataBuilder {

    private Integer id;
    private String nombre;
    private Boolean activo;

    public MenuDtoTestDataBuilder conMenuDtoPorDefecto() {
        this.id = 1;
        this.nombre = "Menu lunes";
        this.activo = false;
        return this;
    }

    public MenuDTO crear() {
        return MenuDTO.crear(id, nombre, activo);
    }
}
