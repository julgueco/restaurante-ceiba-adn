package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.entidad.MenuProducto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuProductoTest {

    @Test
    void deberiaReconstruirMenuProductoCorrectamente() {

        MenuProducto menuProducto = new MenuProductoTestDataBuilder()
                .conMenuProductoPorDefecto()
                .reconstruir();

        Assertions.assertNotNull(menuProducto);
        Assertions.assertEquals(1, menuProducto.getId());
        Assertions.assertEquals(2, menuProducto.getIdMenu());
        Assertions.assertEquals(3, menuProducto.getIdProducto());
    }

    @Test
    void deberiaReconstruirMenuProductoSinIdCorrectamente() {

        MenuProducto menuProducto = new MenuProductoTestDataBuilder()
                .conMenuProductoPorDefecto()
                .reconstruirSinId();

        Assertions.assertNotNull(menuProducto);
        Assertions.assertEquals(null, menuProducto.getId());
        Assertions.assertEquals(2, menuProducto.getIdMenu());
        Assertions.assertEquals(3, menuProducto.getIdProducto());
    }
}
