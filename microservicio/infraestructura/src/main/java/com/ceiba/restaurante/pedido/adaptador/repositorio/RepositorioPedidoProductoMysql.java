/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.restaurante.pedido.modelo.entidad.PedidoProducto;
import com.ceiba.restaurante.pedido.puerto.repositorio.RepositorioPedidoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.guerrero
 */
@Repository
public class RepositorioPedidoProductoMysql implements RepositorioPedidoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoPedidoProducto mapeoPedidoProducto;

    @SqlStatement(namespace = "pedidoproducto", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "pedidoproducto", value = "obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioPedidoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPedidoProducto mapeoPedidoProducto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPedidoProducto = mapeoPedidoProducto;
    }

    @Override
    public long guardar(PedidoProducto pedidoProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_pedido", pedidoProducto.getIdPedido());
        paramSource.addValue("id_producto", pedidoProducto.getIdProducto());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public PedidoProducto obtenerPorId(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()
                -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, mapeoPedidoProducto));
    }

}
