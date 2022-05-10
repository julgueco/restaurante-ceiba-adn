/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.restaurante.menu.modelo.entidad.MenuProducto;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenuProducto;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.guerrero
 */
@Repository
public class RepositorioMenuProductoMysql implements RepositorioMenuProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoMenuProducto mapeoMenuProducto;

    @SqlStatement(namespace = "menuproducto", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "menuproducto", value = "obtenerTodos")
    private static String sqlObtenerTodos;

    @SqlStatement(namespace = "menuproducto", value = "obtenerPorIdMenu")
    private static String sqlObtenerPorId;

    public RepositorioMenuProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoMenuProducto mapeoMenuProducto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoMenuProducto = mapeoMenuProducto;
    }

    @Override
    public Long guardar(MenuProducto menuProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_menu", menuProducto.getIdMenu());
        paramSource.addValue("id_producto", menuProducto.getIdProducto());
        Long idMenuProductoGuardado = this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
        return idMenuProductoGuardado;
    }

    @Override
    public List<MenuProducto> obtenerTodos() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerTodos, paramSource, mapeoMenuProducto);
    }

    @Override
    public List<MenuProducto> obtenerPorIdMenu(Integer idMenu) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_menu", idMenu);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerPorId, paramSource, mapeoMenuProducto);
    }
}
