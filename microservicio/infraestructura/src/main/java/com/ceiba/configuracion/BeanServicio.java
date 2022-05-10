package com.ceiba.configuracion;

import com.ceiba.restaurante.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.restaurante.descuento.servicio.ServicioDescuento;
import com.ceiba.restaurante.descuento.puerto.repositorio.RepositorioDescuento;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenu;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenuProducto;
import com.ceiba.restaurante.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.restaurante.pedido.puerto.repositorio.RepositorioPedidoProducto;
import com.ceiba.restaurante.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.restaurante.cliente.servicio.ServicioCliente;
import com.ceiba.restaurante.menu.servicio.ServicioMenu;
import com.ceiba.restaurante.menu.servicio.ServicioMenuProducto;
import com.ceiba.restaurante.pedido.servicio.ServicioPedido;
import com.ceiba.restaurante.producto.servicio.ServicioProducto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCliente servicioCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCliente(repositorioCliente);
    }

    @Bean
    public ServicioDescuento servicioDescuento(RepositorioDescuento repositorioDescuento) {
        return new ServicioDescuento(repositorioDescuento);
    }

    @Bean
    public ServicioMenu servicioMenu(RepositorioMenu repositorioMenu) {
        return new ServicioMenu(repositorioMenu);
    }

    @Bean
    public ServicioProducto servicioProducto(RepositorioProducto repositorioProducto) {
        return new ServicioProducto(repositorioProducto);
    }

    @Bean
    public ServicioMenuProducto servicioMenuProducto(RepositorioMenuProducto repositorioMenuProducto, RepositorioMenu repositorioMenu, RepositorioProducto repositorioProducto) {
        return new ServicioMenuProducto(repositorioMenuProducto, repositorioMenu, repositorioProducto);
    }

    @Bean
    public ServicioPedido servicioPedido(RepositorioPedido repositorioPedido,
            RepositorioPedidoProducto repositorioPedidoProducto,
            RepositorioCliente repositorioCliente,
            RepositorioDescuento repositorioDescuento) {
        return new ServicioPedido(repositorioPedido, repositorioCliente, repositorioDescuento, repositorioPedidoProducto);
    }
}
