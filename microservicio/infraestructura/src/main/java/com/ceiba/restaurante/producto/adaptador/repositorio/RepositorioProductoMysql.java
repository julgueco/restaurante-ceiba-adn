/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.producto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.restaurante.producto.modelo.entidad.Producto;
import com.ceiba.restaurante.producto.puerto.repositorio.RepositorioProducto;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.guerrero
 */
@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoProducto mapeoProducto;

    @SqlStatement(namespace = "producto", value = "crear")
    private static String sqlCrear;
    
    @SqlStatement(namespace = "producto", value = "obtenerTodos")
    private static String sqlObtenerTodos;

    @SqlStatement(namespace = "producto", value = "actualizarPrecio")
    private static String sqlActualizarPrecio;

    @SqlStatement(namespace = "producto", value = "obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoProducto mapeoProducto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoProducto = mapeoProducto;
    }

    @Override
    public Long guardar(Producto producto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", producto.getNombre());
        paramSource.addValue("precio", producto.getPrecio());
        Long idProductoGuardado = this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
        return idProductoGuardado;
    }

    @Override
    public List<Producto> obtenerTodos() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerTodos, paramSource, mapeoProducto);
    }

    @Override
    public void cambiarPrecio(Producto producto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", producto.getId());
        paramSource.addValue("precio", producto.getPrecio());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarPrecio, paramSource);
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()
                -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, mapeoProducto));
    }
}
