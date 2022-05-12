package com.ceiba.descuento;

import com.ceiba.restaurante.descuento.modelo.dto.DescuentoActivoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DescuentoActivoDtoTest {

    @Test
    void deberiaReconstruirDescuentoCorrectamente() {

        DescuentoActivoDTO descuentoActivoDTO = new DescuentoActivoDtoTestDataBuilder()
                .conDescuentoActivoDtoPorDefecto()
                .crear();

        Assertions.assertNotNull(descuentoActivoDTO);
        Assertions.assertEquals(1, descuentoActivoDTO.getId());
        Assertions.assertEquals(7, descuentoActivoDTO.getCantidadDias());
        Assertions.assertEquals(20, descuentoActivoDTO.getPorcentaje());
    }
}
