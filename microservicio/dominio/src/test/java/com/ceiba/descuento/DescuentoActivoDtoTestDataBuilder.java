package com.ceiba.descuento;

import com.ceiba.restaurante.descuento.modelo.dto.DescuentoActivoDTO;

public class DescuentoActivoDtoTestDataBuilder {

    private Integer id;
    private Integer cantidadDias;
    private Integer porcentaje;

    public DescuentoActivoDtoTestDataBuilder conDescuentoActivoDtoPorDefecto() {
        this.id = 1;
        this.cantidadDias = 7;
        this.porcentaje = 20;
        return this;
    }

    public DescuentoActivoDTO crear() {
        return DescuentoActivoDTO.crear(id, cantidadDias, porcentaje);
    }
}
