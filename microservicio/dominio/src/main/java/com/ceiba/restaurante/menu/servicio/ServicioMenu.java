/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.restaurante.menu.modelo.dto.MenuActivoDTO;
import com.ceiba.restaurante.menu.modelo.dto.MenuDTO;
import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenu;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author julian.guerrero
 */
public class ServicioMenu {

    private final RepositorioMenu repositorioMenu;

    public ServicioMenu(RepositorioMenu repositorioMenu) {
        this.repositorioMenu = repositorioMenu;
    }

    public Long guardar(Menu menu) {
        ValidadorArgumento.validarObligatorio(menu, "No existe un menu para crear");
        ValidadorArgumento.validarObligatorio(menu.getNombre(), "No existe un nombre para el menu");

        return repositorioMenu.guardar(menu);
    }

    public List<MenuActivoDTO> obtenerActivos() {
        List<Menu> listMenu = repositorioMenu.obtenerActivos();

        return listMenu.stream().map(menu
                -> MenuActivoDTO.crear(menu.getId(), menu.getNombre())
        ).collect(Collectors.toList());
    }

    public List<MenuDTO> obtenerTodos() {
        List<Menu> listMenu = repositorioMenu.obtenerTodos();

        return listMenu.stream().map(menu
                -> MenuDTO.crear(menu.getId(), menu.getNombre(), menu.getActivo())
        ).collect(Collectors.toList());
    }

    public void cambiarEstado(Integer id) {
        ValidadorArgumento.validarNumerico(id.toString(), "No existe un menu para cambiar estado");
        Menu menu = repositorioMenu.obtenerPorId(id);
        if (menu == null) {
            throw new ExcepcionSinDatos("Menu no existe");
        }

        menu.cambiarEstado();
        repositorioMenu.cambiarEstado(menu);
    }
}
