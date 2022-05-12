package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.dto.MenuDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuDtoTest {

    @Test
    void deberiaReconstruirMenuDtoCorrectamente() {

        MenuDTO menuDTO = new MenuDtoTestDataBuilder()
                .conMenuDtoPorDefecto()
                .crear();

        Assertions.assertNotNull(menuDTO);
        Assertions.assertEquals(1, menuDTO.getId());
        Assertions.assertEquals("Menu lunes", menuDTO.getNombre());
        Assertions.assertEquals(false, menuDTO.getActivo());
    }
}
