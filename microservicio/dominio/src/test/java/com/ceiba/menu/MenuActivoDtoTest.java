package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.dto.MenuActivoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuActivoDtoTest {

    @Test
    void deberiaReconstruirMenuActivoDtoCorrectamente() {

        MenuActivoDTO menuActivoDTO = new MenuActivoDtoTestDataBuilder()
                .conMenuActivoDtoPorDefecto()
                .crear();

        Assertions.assertNotNull(menuActivoDTO);
        Assertions.assertEquals(1, menuActivoDTO.getId());
        Assertions.assertEquals("Menu lunes", menuActivoDTO.getNombre());
    }
}
