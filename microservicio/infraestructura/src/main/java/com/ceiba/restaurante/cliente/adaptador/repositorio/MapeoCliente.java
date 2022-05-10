package com.ceiba.restaurante.cliente.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoCliente implements RowMapper<Cliente>, MapperResult {

    public MapeoCliente() {
        
    }

    @Override
    public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer id = resultSet.getInt("id");
        String numeroDocumento = resultSet.getString("numero_documento");
        String nombre = resultSet.getString("nombre");
        String celular = resultSet.getString("celular");
        String correo = resultSet.getString("correo");
        Integer cantidadDias = resultSet.getInt("cantidad_dias");

        return new Cliente(id, numeroDocumento, nombre, celular, correo, cantidadDias);
    }
}
