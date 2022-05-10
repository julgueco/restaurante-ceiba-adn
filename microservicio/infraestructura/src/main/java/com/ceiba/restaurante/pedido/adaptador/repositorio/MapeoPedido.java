package com.ceiba.restaurante.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.restaurante.pedido.modelo.entidad.Pedido;
import java.math.BigDecimal;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPedido implements RowMapper<Pedido>, MapperResult {

    public MapeoPedido() {

    }

    @Override
    public Pedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer idCliente = resultSet.getInt("id_cliente");
        Integer idDescuento = resultSet.getInt("id_descuento");
        BigDecimal precioTotal = resultSet.getBigDecimal("precio_total");
        Boolean precioBase = resultSet.getBoolean("precio_base");

        return new Pedido(id, idCliente, idDescuento, precioTotal, precioBase);
    }
}
