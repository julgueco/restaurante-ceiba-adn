package com.ceiba.restaurante.menu.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoMenu implements RowMapper<Menu>, MapperResult {

    @Override
    public Menu mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        Boolean activo = resultSet.getBoolean("activo");

        return new Menu(id, nombre, activo);
    }
}
