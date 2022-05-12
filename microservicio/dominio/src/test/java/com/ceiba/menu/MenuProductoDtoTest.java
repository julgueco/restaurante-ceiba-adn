package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.dto.MenuProductoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuProductoDtoTest {

    @Test
    void deberiaReconstruirMenuProductoDtoCorrectamente() {

        MenuProductoDTO menuProductoDTO = new MenuProductoDtoTestDataBuilder()
                .conMenuProductoDtoPorDefecto()
                .crear();

        Assertions.assertNotNull(menuProductoDTO);
        Assertions.assertEquals(1, menuProductoDTO.getId());
        Assertions.assertEquals(2, menuProductoDTO.getIdMenu());
        Assertions.assertEquals(3, menuProductoDTO.getIdProducto());
    }
}
