package com.ceiba.cliente;

import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void deberiaReconstruirClienteCorrectamente() {

        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .reconstruir();

        Assertions.assertNotNull(cliente);
        Assertions.assertEquals(1, cliente.getId());
        Assertions.assertEquals("123456789", cliente.getNumeroDocumento());
        Assertions.assertEquals("Prueba nombre", cliente.getNombre());
        Assertions.assertEquals("3133333333", cliente.getCelular());
        Assertions.assertEquals("pruebacorreo@prueba.com", cliente.getCorreo());
        Assertions.assertEquals(0, cliente.getCantidadDias());
    }

    @Test
    void deberiaReconstruirClienteSinIdCorrectamente() {

        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .reconstruirSinId();

        Assertions.assertNotNull(cliente);
        Assertions.assertEquals(null, cliente.getId());
        Assertions.assertEquals("123456789", cliente.getNumeroDocumento());
        Assertions.assertEquals("Prueba nombre", cliente.getNombre());
        Assertions.assertEquals("3133333333", cliente.getCelular());
        Assertions.assertEquals("pruebacorreo@prueba.com", cliente.getCorreo());
        Assertions.assertEquals(0, cliente.getCantidadDias());
    }
}
