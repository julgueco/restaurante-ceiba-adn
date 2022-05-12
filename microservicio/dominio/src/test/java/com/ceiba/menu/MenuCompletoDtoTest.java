package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.dto.MenuCompletoDTO;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuCompletoDtoTest {

    @Test
    void deberiaReconstruirMenuCompletoDtoCorrectamente() {

        MenuCompletoDTO menuCompletoDTO = new MenuCompletoDtoTestDataBuilder()
                .conMenuCompletoDtoPorDefecto()
                .crear();

        Assertions.assertNotNull(menuCompletoDTO);
        Assertions.assertEquals(1, menuCompletoDTO.getId());
        Assertions.assertEquals("Menu lunes", menuCompletoDTO.getNombre());
        Assertions.assertEquals(false, menuCompletoDTO.getActivo());
        Assertions.assertEquals(3, menuCompletoDTO.getProductos().size());
    }
}
