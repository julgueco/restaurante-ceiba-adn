package com.ceiba.descuento;

import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DescuentoTest {

    @Test
    void deberiaReconstruirLaFacturaCorrectamente() {

        Descuento descuento = new DescuentoTestDataBuilder()
                .conDescuentoPorDefecto()
                .reconstruir();

        Assertions.assertNotNull(descuento);
        Assertions.assertEquals(1, descuento.getId());
        Assertions.assertEquals(false, descuento.getActivo());
        Assertions.assertEquals(7, descuento.getCantidadDias());
        Assertions.assertEquals(20, descuento.getPorcentaje());
    }
}
