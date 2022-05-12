package com.ceiba.descuento;

import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DescuentoTest {

    @Test
    void deberiaReconstruirDescuentoCorrectamente() {

        Descuento descuento = new DescuentoTestDataBuilder()
                .conDescuentoPorDefecto()
                .reconstruir();

        Assertions.assertNotNull(descuento);
        Assertions.assertEquals(1, descuento.getId());
        Assertions.assertEquals(false, descuento.getActivo());
        Assertions.assertEquals(7, descuento.getCantidadDias());
        Assertions.assertEquals(20, descuento.getPorcentaje());
    }

    @Test
    void deberiaReconstruirDescuentoSinIdCorrectamente() {

        Descuento descuento = new DescuentoTestDataBuilder()
                .conDescuentoPorDefecto()
                .reconstruirSinId();

        Assertions.assertNotNull(descuento);
        Assertions.assertEquals(null, descuento.getId());
        Assertions.assertEquals(false, descuento.getActivo());
        Assertions.assertEquals(7, descuento.getCantidadDias());
        Assertions.assertEquals(20, descuento.getPorcentaje());
    }

    @Test
    void deberiaCambiarEstadoDescuentoCorrectamente() {

        Descuento descuento = new DescuentoTestDataBuilder()
                .conDescuentoPorDefecto()
                .reconstruir();
        descuento.cambiarEstado();

        Assertions.assertNotNull(descuento);
        Assertions.assertEquals(1, descuento.getId());
        Assertions.assertEquals(true, descuento.getActivo());
        Assertions.assertEquals(7, descuento.getCantidadDias());
        Assertions.assertEquals(20, descuento.getPorcentaje());
    }
}
