/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.producto.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import com.ceiba.restaurante.producto.modelo.entidad.Producto;
import com.ceiba.restaurante.producto.puerto.repositorio.RepositorioProducto;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author julian.guerrero
 */
public class ServicioProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long guardar(Producto producto) {
        ValidadorArgumento.validarObligatorio(producto, "No existe un producto para crear");
        ValidadorArgumento.validarObligatorio(producto.getNombre(), "No existe un nombre para el producto");
        ValidadorArgumento.validarDecimal(producto.getPrecio().toString(), "No existe un precio para el producto");

        List<Producto> listProducto = repositorioProducto.obtenerTodos();
        if (listProducto != null && listProducto.stream().anyMatch(prod -> producto.getNombre().equalsIgnoreCase(prod.getNombre()))) {
            throw new ExcepcionDuplicidad("Nombre de producto existente");
        }
        return repositorioProducto.guardar(producto);
    }

    public List<ProductoDTO> obtenerTodos() {
        List<Producto> listProducto = repositorioProducto.obtenerTodos();

        return listProducto.stream().map(producto
                -> ProductoDTO.crear(producto.getId(), producto.getNombre(), producto.getPrecio())
        ).collect(Collectors.toList());
    }

    public void cambiarPrecio(Integer id, BigDecimal precio) {
        ValidadorArgumento.validarNumerico(id.toString(), "No existe un producto para cambiar precio");
        ValidadorArgumento.validarDecimal(precio.toString(), "No existe un precio para cambiar");
        Producto producto = repositorioProducto.obtenerPorId(id);
        if (producto == null) {
            throw new ExcepcionSinDatos("Producto no existe");
        }

        producto.cambiarPrecio(precio);
        repositorioProducto.cambiarPrecio(producto);
    }
}
