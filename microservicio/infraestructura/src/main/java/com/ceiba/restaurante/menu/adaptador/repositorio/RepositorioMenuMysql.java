/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.menu.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenu;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.guerrero
 */
@Repository
public class RepositorioMenuMysql implements RepositorioMenu {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoMenu mapeoMenu;

    @SqlStatement(namespace = "menu", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "menu", value = "obtenerActivos")
    private static String sqlObtenerActivos;
    
    @SqlStatement(namespace = "menu", value = "obtenerTodos")
    private static String sqlObtenerTodos;

    @SqlStatement(namespace = "menu", value = "actualizarEstado")
    private static String sqlActualizarEstado;

    @SqlStatement(namespace = "menu", value = "obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioMenuMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoMenu mapeoMenu) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoMenu = mapeoMenu;
    }

    @Override
    public Long guardar(Menu menu) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", menu.getNombre());
        paramSource.addValue("activo", menu.getActivo());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public List<Menu> obtenerActivos() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerActivos, paramSource, mapeoMenu);
    }

    @Override
    public List<Menu> obtenerTodos() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerTodos, paramSource, mapeoMenu);
    }

    @Override
    public void cambiarEstado(Menu menu) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", menu.getId());
        paramSource.addValue("activo", menu.getActivo());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarEstado, paramSource);
    }

    @Override
    public Menu obtenerPorId(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()
                -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, mapeoMenu));
    }
}
