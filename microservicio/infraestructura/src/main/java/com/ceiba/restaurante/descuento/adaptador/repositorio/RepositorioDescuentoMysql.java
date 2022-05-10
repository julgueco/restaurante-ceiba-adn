/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.descuento.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import com.ceiba.restaurante.descuento.puerto.repositorio.RepositorioDescuento;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.guerrero
 */
@Repository
public class RepositorioDescuentoMysql implements RepositorioDescuento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoDescuento mapeoDescuento;

    @SqlStatement(namespace = "descuento", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "descuento", value = "obtenerActivos")
    private static String sqlObtenerActivos;

    @SqlStatement(namespace = "descuento", value = "actualizarEstado")
    private static String sqlActualizarEstado;

    @SqlStatement(namespace = "descuento", value = "obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioDescuentoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoDescuento mapeoDescuento) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoDescuento = mapeoDescuento;
    }

    @Override
    public Long guardar(Descuento descuento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cantidad_dias", descuento.getCantidadDias());
        paramSource.addValue("porcentaje", descuento.getPorcentaje());
        paramSource.addValue("activo", descuento.getActivo());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public List<Descuento> obtenerActivos() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerActivos, paramSource, mapeoDescuento);
    }

    @Override
    public void cambiarEstado(Descuento descuento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", descuento.getId());
        paramSource.addValue("activo", descuento.getActivo());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarEstado, paramSource);
    }

    @Override
    public Descuento obtenerPorId(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()
                -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, mapeoDescuento));
    }
}
