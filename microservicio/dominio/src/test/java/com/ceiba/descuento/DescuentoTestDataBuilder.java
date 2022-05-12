package com.ceiba.descuento;

import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;

public class DescuentoTestDataBuilder {

    private Integer id;
    private Integer cantidadDias;
    private Boolean activo;
    private Integer porcentaje;

    public DescuentoTestDataBuilder conDescuentoPorDefecto() {
        this.id = 1;
        this.cantidadDias = 7;
        this.activo = false;
        this.porcentaje = 20;
        return this;
    }

    public Descuento reconstruir() {
        return new Descuento(id, cantidadDias, porcentaje, activo);
    }

    public Descuento reconstruirSinId() {
        return new Descuento(cantidadDias, porcentaje, activo);
    }
}
