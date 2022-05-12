package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.dto.MenuActivoDTO;

public class MenuActivoDtoTestDataBuilder {

    private Integer id;
    private String nombre;

    public MenuActivoDtoTestDataBuilder conMenuActivoDtoPorDefecto() {
        this.id = 1;
        this.nombre = "Menu lunes";
        return this;
    }

    public MenuActivoDTO crear() {
        return MenuActivoDTO.crear(id, nombre);
    }
}
