package com.ceiba.restaurante.producto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.restaurante.producto.modelo.entidad.Producto;
import java.math.BigDecimal;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoProducto implements RowMapper<Producto>, MapperResult {

    public MapeoProducto() {

    }

    @Override
    public Producto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        BigDecimal precio = resultSet.getBigDecimal("precio");

        return new Producto(id, nombre, precio);
    }
}
