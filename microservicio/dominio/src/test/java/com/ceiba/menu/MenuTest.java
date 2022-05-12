package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void deberiaReconstruirMenuCorrectamente() {

        Menu menu = new MenuTestDataBuilder()
                .conMenuPorDefecto()
                .reconstruir();

        Assertions.assertNotNull(menu);
        Assertions.assertEquals(1, menu.getId());
        Assertions.assertEquals("Menu lunes", menu.getNombre());
        Assertions.assertEquals(false, menu.getActivo());
    }

    @Test
    void deberiaReconstruirMenuSinIdCorrectamente() {

        Menu menu = new MenuTestDataBuilder()
                .conMenuPorDefecto()
                .reconstruirSinId();

        Assertions.assertNotNull(menu);
        Assertions.assertEquals(null, menu.getId());
        Assertions.assertEquals("Menu lunes", menu.getNombre());
        Assertions.assertEquals(false, menu.getActivo());
    }

    @Test
    void deberiaCambiarEstadoMenuCorrectamente() {

        Menu menu = new MenuTestDataBuilder()
                .conMenuPorDefecto()
                .reconstruir();
        menu.cambiarEstado();

        Assertions.assertNotNull(menu);
        Assertions.assertEquals(1, menu.getId());
        Assertions.assertEquals("Menu lunes", menu.getNombre());
        Assertions.assertEquals(true, menu.getActivo());
    }
}
