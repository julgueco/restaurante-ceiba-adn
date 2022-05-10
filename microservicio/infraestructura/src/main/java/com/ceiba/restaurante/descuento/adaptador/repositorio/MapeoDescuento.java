package com.ceiba.restaurante.descuento.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoDescuento implements RowMapper<Descuento>, MapperResult {

 

    public MapeoDescuento() {
        
    }

    @Override
    public Descuento mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer cantidadDias = resultSet.getInt("cantidad_dias");
        Integer porcentaje = resultSet.getInt("porcentaje");
        Boolean activo = resultSet.getBoolean("activo");

        return new Descuento(id, cantidadDias, porcentaje, activo);
    }
}
