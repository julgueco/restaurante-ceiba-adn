package com.ceiba.cliente;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;
import com.ceiba.restaurante.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.restaurante.cliente.servicio.ServicioCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ServicioClienteTest {

    @Test
    void deberiaGenerarClienteYGuardar() {
        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .reconstruirSinId();

        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.guardar(Mockito.any())).thenReturn(1l);
        Mockito.when(repositorioCliente.obtenerPorNumeroDocumento(cliente.getNumeroDocumento())).thenReturn(null);

        ServicioCliente servicioCliente = new ServicioCliente(repositorioCliente);

        Long idClienteCreada = servicioCliente.guardar(cliente);

        ArgumentCaptor<String> captorObtener = ArgumentCaptor.forClass(String.class);
        Mockito.verify(repositorioCliente, Mockito.times(1)).obtenerPorNumeroDocumento(captorObtener.capture());
        ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
        Mockito.verify(repositorioCliente, Mockito.times(1)).guardar(captor.capture());
        Assertions.assertEquals(cliente.getNumeroDocumento(), captorObtener.getValue());
        Assertions.assertEquals(cliente, captor.getValue());
        Assertions.assertEquals(cliente.getNumeroDocumento(), captor.getValue().getNumeroDocumento());
        Assertions.assertEquals(cliente.getNombre(), captor.getValue().getNombre());
        Assertions.assertEquals(cliente.getCelular(), captor.getValue().getCelular());
        Assertions.assertEquals(cliente.getCorreo(), captor.getValue().getCorreo());
        Assertions.assertEquals(cliente.getCantidadDias(), captor.getValue().getCantidadDias());
        Assertions.assertEquals(1l, idClienteCreada);
    }

    @Test
    void deberiaGenerarExcepcionDuplicidadCliente() {
        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .reconstruirSinId();

        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.guardar(Mockito.any())).thenReturn(1l);
        Mockito.when(repositorioCliente.obtenerPorNumeroDocumento(cliente.getNumeroDocumento())).thenReturn(cliente);

        ServicioCliente servicioCliente = new ServicioCliente(repositorioCliente);

        Exception exception = Assertions.assertThrows(ExcepcionDuplicidad.class, () -> {
            servicioCliente.guardar(cliente);
        });

        ArgumentCaptor<String> captorObtener = ArgumentCaptor.forClass(String.class);
        Mockito.verify(repositorioCliente, Mockito.times(1)).obtenerPorNumeroDocumento(captorObtener.capture());
        Assertions.assertEquals(cliente.getNumeroDocumento(), captorObtener.getValue());
        Assertions.assertEquals("Cliente ya existe", exception.getMessage());
    }
}
