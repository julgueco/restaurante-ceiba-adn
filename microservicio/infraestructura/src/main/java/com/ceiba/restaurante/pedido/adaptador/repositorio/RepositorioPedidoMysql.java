/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.restaurante.pedido.modelo.entidad.Pedido;
import com.ceiba.restaurante.pedido.puerto.repositorio.RepositorioPedido;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.guerrero
 */
@Repository
public class RepositorioPedidoMysql implements RepositorioPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoPedido mapeoPedido;

    @SqlStatement(namespace = "pedido", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "pedido", value = "obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPedido mapeoPedido) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPedido = mapeoPedido;
    }

    @Override
    public Integer guardar(Pedido pedido) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_cliente", pedido.getIdCliente());
        paramSource.addValue("id_descuento", pedido.getIdDescuento());
        paramSource.addValue("precio_total", pedido.getPrecioTotal());
        paramSource.addValue("precio_base", pedido.getPrecioBase());
        return Integer.parseInt(this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear).toString());
    }

    @Override
    public Pedido obtenerPorId(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()
                -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, mapeoPedido));
    }
}
