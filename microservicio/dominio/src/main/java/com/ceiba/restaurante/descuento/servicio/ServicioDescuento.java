/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.descuento.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.restaurante.descuento.modelo.dto.DescuentoActivoDTO;
import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import com.ceiba.restaurante.descuento.puerto.repositorio.RepositorioDescuento;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author julian.guerrero
 */
public class ServicioDescuento {

    private final RepositorioDescuento repositorioDescuento;

    public ServicioDescuento(RepositorioDescuento repositorioDescuento) {
        this.repositorioDescuento = repositorioDescuento;
    }

    public Long guardar(Descuento descuento) {
        ValidadorArgumento.validarObligatorio(descuento, "No existe un descuento para crear");
        ValidadorArgumento.validarNumerico(descuento.getCantidadDias().toString(), "No existe una cantidad de dias para aplicar descuento");
        ValidadorArgumento.validarNumerico(descuento.getPorcentaje().toString(), "No existe un porcentaje para aplicar descuento");

        return repositorioDescuento.guardar(descuento);
    }

    public List<DescuentoActivoDTO> obtenerActivos() {
        List<Descuento> listDescuento = repositorioDescuento.obtenerActivos();

        return listDescuento.stream().map(descuento
                -> DescuentoActivoDTO.crear(descuento.getId(), descuento.getCantidadDias(), descuento.getPorcentaje())
        ).collect(Collectors.toList());
    }

    public void cambiarEstado(Integer id) {
        ValidadorArgumento.validarNumerico(id.toString(), "No existe un descuento para cambiar estado");
        Descuento descuento = repositorioDescuento.obtenerPorId(id);
        if (descuento == null) {
            throw new ExcepcionSinDatos("Descuento no existe");
        }

        descuento.cambiarEstado();
        repositorioDescuento.cambiarEstado(descuento);
    }
}
