package com.ceiba.menu;

import com.ceiba.descuento.*;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.restaurante.descuento.modelo.dto.DescuentoActivoDTO;
import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import com.ceiba.restaurante.descuento.puerto.repositorio.RepositorioDescuento;
import com.ceiba.restaurante.descuento.servicio.ServicioDescuento;
import com.ceiba.restaurante.menu.modelo.dto.MenuActivoDTO;
import com.ceiba.restaurante.menu.modelo.dto.MenuDTO;
import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenu;
import com.ceiba.restaurante.menu.servicio.ServicioMenu;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ServicioMenuTest {

    @Test
    void deberiaGenerarMenuYGuardar() {
        Menu menu = new MenuTestDataBuilder()
                .conMenuPorDefecto()
                .reconstruirSinId();

        RepositorioMenu repositorioMenu = Mockito.mock(RepositorioMenu.class);
        Mockito.when(repositorioMenu.guardar(Mockito.any())).thenReturn(1l);
        ServicioMenu servicioMenu = new ServicioMenu(repositorioMenu);

        Long idMenuCreada = servicioMenu.guardar(menu);

        ArgumentCaptor<Menu> captor = ArgumentCaptor.forClass(Menu.class);
        Mockito.verify(repositorioMenu, Mockito.times(1)).guardar(captor.capture());
        Assertions.assertEquals(menu, captor.getValue());
        Assertions.assertEquals(menu.getNombre(), captor.getValue().getNombre());
        Assertions.assertEquals(menu.getActivo(), captor.getValue().getActivo());
        Assertions.assertEquals(1l, idMenuCreada);
    }

    @Test
    void deberiaObtenerMenuActivos() {
        List<Menu> list = new ArrayList<Menu>();
        list.add(new MenuTestDataBuilder()
                .conMenuPorDefecto()
                .reconstruir());

        RepositorioMenu repositorioMenu = Mockito.mock(RepositorioMenu.class);
        Mockito.when(repositorioMenu.obtenerActivos()).thenReturn(list);
        ServicioMenu servicioMenu = new ServicioMenu(repositorioMenu);

        List<MenuActivoDTO> menuActivoDTOs = servicioMenu.obtenerActivos();

        Mockito.verify(repositorioMenu, Mockito.times(1)).obtenerActivos();
        Assertions.assertEquals(menuActivoDTOs.size(), list.size());
        Assertions.assertEquals(menuActivoDTOs.get(0).getNombre(), list.get(0).getNombre());
        Assertions.assertEquals(menuActivoDTOs.get(0).getId(), list.get(0).getId());
    }

    @Test
    void deberiaObtenerMenus() {
        List<Menu> list = new ArrayList<Menu>();
        list.add(new MenuTestDataBuilder()
                .conMenuPorDefecto()
                .reconstruir());

        RepositorioMenu repositorioMenu = Mockito.mock(RepositorioMenu.class);
        Mockito.when(repositorioMenu.obtenerTodos()).thenReturn(list);
        ServicioMenu servicioMenu = new ServicioMenu(repositorioMenu);

        List<MenuDTO> menuDTO = servicioMenu.obtenerTodos();

        Mockito.verify(repositorioMenu, Mockito.times(1)).obtenerTodos();
        Assertions.assertEquals(menuDTO.size(), list.size());
        Assertions.assertEquals(menuDTO.get(0).getNombre(), list.get(0).getNombre());
        Assertions.assertEquals(menuDTO.get(0).getId(), list.get(0).getId());        
        Assertions.assertEquals(menuDTO.get(0).getActivo(), list.get(0).getActivo());
    }

    @Test
    void deberiaCambiarEstado() {
        Menu menu = new MenuTestDataBuilder()
                .conMenuPorDefecto()
                .reconstruir();

        RepositorioMenu repositorioMenu = Mockito.mock(RepositorioMenu.class);
        Mockito.when(repositorioMenu.obtenerPorId(menu.getId())).thenReturn(menu);
        menu.cambiarEstado();
        Mockito.when(repositorioMenu.cambiarEstado(menu)).thenReturn(menu.getId());

        ServicioMenu servicioMenu = new ServicioMenu(repositorioMenu);
        servicioMenu.cambiarEstado(menu.getId());

        ArgumentCaptor<Integer> captorObtener = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(repositorioMenu, Mockito.times(1)).obtenerPorId(captorObtener.capture());
        ArgumentCaptor<Menu> captor = ArgumentCaptor.forClass(Menu.class);
        Mockito.verify(repositorioMenu, Mockito.times(1)).cambiarEstado(captor.capture());
        Assertions.assertEquals(menu.getId(), captorObtener.getValue());
        Assertions.assertEquals(menu, captor.getValue());
        Assertions.assertEquals(menu.getId(), captor.getValue().getId());
        Assertions.assertEquals(menu.getNombre(), captor.getValue().getNombre());
        Assertions.assertEquals(menu.getActivo(), captor.getValue().getActivo());
    }

    @Test
    void deberiaGenerarExceptionCambiarEstado() {
        Menu menu = new MenuTestDataBuilder()
                .conMenuPorDefecto()
                .reconstruir();

        RepositorioMenu repositorioMenu = Mockito.mock(RepositorioMenu.class);
        Mockito.when(repositorioMenu.obtenerPorId(menu.getId())).thenReturn(null);

        ServicioMenu servicioMenu = new ServicioMenu(repositorioMenu);

        Exception exception = Assertions.assertThrows(ExcepcionSinDatos.class, () -> {
            servicioMenu.cambiarEstado(menu.getId());
        });

        ArgumentCaptor<Integer> captorObtener = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(repositorioMenu, Mockito.times(1)).obtenerPorId(captorObtener.capture());
        Assertions.assertEquals(menu.getId(), captorObtener.getValue());
        Assertions.assertEquals("Menu no existe", exception.getMessage());
    }
}
