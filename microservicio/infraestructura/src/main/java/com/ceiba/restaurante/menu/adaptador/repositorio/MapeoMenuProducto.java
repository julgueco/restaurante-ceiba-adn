package com.ceiba.restaurante.menu.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.restaurante.menu.modelo.entidad.MenuProducto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoMenuProducto implements RowMapper<MenuProducto>, MapperResult {

    public MapeoMenuProducto() {

    }

    @Override
    public MenuProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer idMenu = resultSet.getInt("id_menu");
        Integer idProducto = resultSet.getInt("id_producto");

        return new MenuProducto(id, idMenu, idProducto);
    }
}
