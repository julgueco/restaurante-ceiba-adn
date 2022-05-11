/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.restaurante.pedido.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.restaurante.producto.modelo.dto.ProductoDTO;
import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;
import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import com.ceiba.restaurante.pedido.modelo.entidad.Pedido;
import com.ceiba.restaurante.pedido.modelo.entidad.PedidoProducto;
import com.ceiba.restaurante.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.restaurante.descuento.puerto.repositorio.RepositorioDescuento;
import com.ceiba.restaurante.pedido.modelo.dto.PedidoDTO;
import com.ceiba.restaurante.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.restaurante.pedido.puerto.repositorio.RepositorioPedidoProducto;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author julian.guerrero
 */
public class ServicioPedido {

    private final BigDecimal precioBaseSemana = BigDecimal.valueOf(8000);
    private final BigDecimal precioBaseFinSemana = BigDecimal.valueOf(10000);

    private final RepositorioPedido repositorioPedido;
    private final RepositorioPedidoProducto repositorioPedidoProducto;
    private final RepositorioCliente repositorioCliente;
    private final RepositorioDescuento repositorioDescuento;

    public ServicioPedido(RepositorioPedido repositorioPedido,
            RepositorioCliente repositorioCliente,
            RepositorioDescuento repositorioDescuento,
            RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioCliente = repositorioCliente;
        this.repositorioDescuento = repositorioDescuento;
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public PedidoDTO calcularGuardarPedido(Integer idCliente, List<ProductoDTO> listaProductos) {
        BigDecimal precioTotal = this.validarPrecioProductos(listaProductos);
        Cliente cliente = this.validarCliente(idCliente);

        Pedido pedido;
        if (this.validarFinSemana(new Date()) && precioTotal.compareTo(this.precioBaseFinSemana) < 0) {
            precioTotal = this.precioBaseFinSemana;
            pedido = new Pedido(idCliente, precioTotal, true);
        } else if (precioTotal.compareTo(this.precioBaseSemana) < 0) {
            precioTotal = this.precioBaseSemana;
            pedido = new Pedido(idCliente, precioTotal, true);
        } else {
            pedido = new Pedido(idCliente, precioTotal, false);
        }

        this.validarDescuento(pedido, cliente);
        Integer idPedido = repositorioPedido.guardar(pedido);

        listaProductos.forEach(producto -> this.repositorioPedidoProducto.guardar(new PedidoProducto(idPedido, producto.getId())));
        this.repositorioCliente.actualizarCantidadDias(cliente);
        
        return new PedidoDTO(idPedido, pedido.getPrecioTotal());
    }

    private void validarDescuento(Pedido pedido, Cliente cliente) {
        List<Descuento> descuentosActivos = repositorioDescuento.obtenerActivos();

        Descuento descuentoAplicar = descuentosActivos.stream()
                .filter(descuento -> cliente.getCantidadDias().equals(descuento.getCantidadDias()))
                .findAny()
                .orElse(null);

        if (descuentoAplicar != null) {
            pedido.agregarDescuento(descuentoAplicar.getId(), descuentoAplicar.getPorcentaje());
        }

        Optional<Descuento> optinoal = descuentosActivos.stream().max(Comparator.comparing(Descuento::getCantidadDias));
        if (optinoal.isPresent()) {
            Descuento ultimoDescuento = optinoal.get();

            if (ultimoDescuento.getCantidadDias().equals(cliente.getCantidadDias())) {
                cliente.reiniciarCantidadDias();
            }
        }
    }

    private BigDecimal validarPrecioProductos(List<ProductoDTO> listaProductos) {
        ValidadorArgumento.validarObligatorio(listaProductos, "No existen productos en el pedido");
        ValidadorArgumento.validarNoVacio(listaProductos, "No existen productos en el pedido");
        ValidadorArgumento.validarCantidadMinima(listaProductos, 3, "Cantidad minima de productos invalida");

        BigDecimal precioTotal = BigDecimal.ZERO;
        for (ProductoDTO producto : listaProductos) {
            precioTotal = precioTotal.add(producto.getPrecio());
        }

        return precioTotal;
    }

    private Cliente validarCliente(Integer idCliente) {
        ValidadorArgumento.validarObligatorio(idCliente, "No existe un id cliente para el pedido");
        ValidadorArgumento.validarNumerico(idCliente.toString(), "No existe un id cliente para el pedido");
        Cliente cliente = repositorioCliente.obtenerPorId(idCliente);
        if (cliente == null) {
            throw new ExcepcionSinDatos("Cliente no existe");
        }

        cliente.sumarDia();
        return cliente;
    }

    private boolean validarFinSemana(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return day == Calendar.SATURDAY || day == Calendar.SUNDAY;
    }
}
