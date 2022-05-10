/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.cliente.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;
import com.ceiba.restaurante.cliente.puerto.repositorio.RepositorioCliente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.guerrero
 */
@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoCliente mapeoCliente;

    @SqlStatement(namespace = "cliente", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "cliente", value = "obtenerPorNumeroDocumento")
    private static String sqlObtenerPorNumeroDocumento;

    @SqlStatement(namespace = "cliente", value = "actualizarCantidadDias")
    private static String sqlActualizarCantidadDias;

    @SqlStatement(namespace = "cliente", value = "obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoCliente mapeoCliente) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoCliente = mapeoCliente;
    }

    @Override
    public Long guardar(Cliente cliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numero_documento", cliente.getNumeroDocumento());
        paramSource.addValue("nombre", cliente.getNombre());
        paramSource.addValue("celular", cliente.getCelular());
        paramSource.addValue("correo", cliente.getCorreo());
        paramSource.addValue("cantidad_dias", cliente.getCantidadDias());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public Cliente obtenerPorId(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()
                -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, mapeoCliente));
    }

    @Override
    public Cliente obtenerPorNumeroDocumento(String numeroDocumento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numero_documento", numeroDocumento);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()
                -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorNumeroDocumento,
                        paramSource, mapeoCliente));
    }

    @Override
    public void actualizarCantidadDias(Cliente cliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", cliente.getId());
        paramSource.addValue("cantidad_dias", cliente.getCantidadDias());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarCantidadDias, paramSource);
    }
}
