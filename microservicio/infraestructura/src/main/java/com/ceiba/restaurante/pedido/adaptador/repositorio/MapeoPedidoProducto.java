package com.ceiba.restaurante.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.restaurante.pedido.modelo.entidad.PedidoProducto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPedidoProducto implements RowMapper<PedidoProducto>, MapperResult {

    @Override
    public PedidoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer idPedido = resultSet.getInt("id_pedido");
        Integer idProducto = resultSet.getInt("id_producto");

        return new PedidoProducto(id, idPedido, idProducto);
    }
}
