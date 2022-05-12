package com.ceiba.menu;

import com.ceiba.restaurante.menu.modelo.dto.MenuCompletoDTO;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MenuCompletoDtoTestDataBuilder {

    private Integer id;
    private String nombre;
    private Boolean activo;
    private List<ProductoDTO> productos;

    public MenuCompletoDtoTestDataBuilder conMenuCompletoDtoPorDefecto() {
        this.id = 1;
        this.nombre = "Menu lunes";
        this.activo = false;
        this.productos = this.crearProductos();
        return this;
    }

    private List<ProductoDTO> crearProductos() {
        List<ProductoDTO> productos = new ArrayList<ProductoDTO>();
        productos.add(new ProductoDTO(1, "Papa a la francesa", BigDecimal.valueOf(3000)));
        productos.add(new ProductoDTO(2, "Carne asada", BigDecimal.valueOf(4000)));
        productos.add(new ProductoDTO(3, "Crema de zanahoria", BigDecimal.valueOf(3000)));
        return productos;
    }

    public MenuCompletoDTO crear() {
        return MenuCompletoDTO.crear(id, nombre, activo, productos);
    }
}
