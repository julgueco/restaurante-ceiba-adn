/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.restaurante.menu.modelo.dto.MenuCompletoDTO;
import com.ceiba.restaurante.menu.modelo.dto.MenuProductoDTO;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import com.ceiba.restaurante.menu.modelo.entidad.MenuProducto;
import com.ceiba.restaurante.producto.modelo.entidad.Producto;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenu;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenuProducto;
import com.ceiba.restaurante.producto.puerto.repositorio.RepositorioProducto;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author julian.guerrero
 */
public class ServicioMenuProducto {

    private final RepositorioMenuProducto repositorioMenuProducto;
    private final RepositorioMenu repositorioMenu;
    private final RepositorioProducto repositorioProducto;

    public ServicioMenuProducto(RepositorioMenuProducto repositorioMenuProducto, RepositorioMenu repositorioMenu, RepositorioProducto repositorioProducto) {
        this.repositorioMenuProducto = repositorioMenuProducto;
        this.repositorioMenu = repositorioMenu;
        this.repositorioProducto = repositorioProducto;
    }

    public Long guardar(MenuProducto menuProducto) {
        ValidadorArgumento.validarObligatorio(menuProducto, "No existe una relacion entre el menu y un producto para crear");
        ValidadorArgumento.validarNumerico(menuProducto.getIdMenu().toString(), "No existe un id menu para la relacion entre el menu y un producto");
        ValidadorArgumento.validarNumerico(menuProducto.getIdProducto().toString(), "No existe un id producto para la relacion entre el menu y un producto");

        Producto producto = repositorioProducto.obtenerPorId(menuProducto.getIdProducto());
        if (producto == null) {
            throw new ExcepcionSinDatos("Producto no existe");
        }

        Menu menu = repositorioMenu.obtenerPorId(menuProducto.getIdMenu());
        if (menu == null) {
            throw new ExcepcionSinDatos("Menu no existe");
        }

        List<MenuProducto> listMenuProducto = repositorioMenuProducto.obtenerPorIdMenu(menuProducto.getIdMenu());
        if (listMenuProducto != null && listMenuProducto.stream().anyMatch(l -> l.getIdProducto().equals(menuProducto.getIdProducto()))) {
            throw new ExcepcionDuplicidad("Producto existe en el menu");
        }

        return repositorioMenuProducto.guardar(menuProducto);
    }

    public List<MenuProductoDTO> obtenerTodos() {
        List<MenuProducto> listMenuProducto = repositorioMenuProducto.obtenerTodos();

        return listMenuProducto.stream().map(menuProducto
                -> MenuProductoDTO.crear(menuProducto.getId(), menuProducto.getIdMenu(), menuProducto.getIdProducto())
        ).collect(Collectors.toList());
    }

    public MenuCompletoDTO obtenerMenuCompletoPorIdMenu(Integer idMenu) {
        Menu menu = repositorioMenu.obtenerPorId(idMenu);
        if (menu == null) {
            throw new ExcepcionSinDatos("Menu no existe");
        }

        List<MenuProducto> listMenuProducto = repositorioMenuProducto.obtenerPorIdMenu(idMenu);
        ValidadorArgumento.validarObligatorio(listMenuProducto, "No se encontraron productos asociados al menu");
        ValidadorArgumento.validarNoVacio(listMenuProducto, "No se encontraron productos asociados al menu");

        List<Producto> productos = listMenuProducto.stream().map(menuProducto
                -> repositorioProducto.obtenerPorId(menuProducto.getIdProducto())).collect(Collectors.toList());

        return MenuCompletoDTO.crear(idMenu, menu.getNombre(), menu.getActivo(),
                productos.stream().map(producto -> new ProductoDTO(producto.getId(), producto.getNombre(), producto.getPrecio())).collect(Collectors.toList())
        );
    }
}
