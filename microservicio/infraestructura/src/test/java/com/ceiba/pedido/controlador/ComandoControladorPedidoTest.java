/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.restaurante.pedido.comando.ComandoCalcularGuardarPedido;
import com.ceiba.restaurante.pedido.controlador.ComandoControladorPedido;
import com.ceiba.restaurante.pedido.modelo.entidad.Pedido;
import com.ceiba.restaurante.pedido.puerto.repositorio.RepositorioPedido;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author julian.guerrero
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPedido.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorPedidoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioPedido repositorioPedido;

    @Test
    void crearPedidoExitosa() throws Exception {
        ComandoCalcularGuardarPedido comandoCalcularGuardarPedidoTestDataBuilder = new ComandoPedidoTestDataBuilder().crearPorDefecto().build();

        MvcResult resultado = mocMvc.perform(post("/pedido")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCalcularGuardarPedidoTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        RespuestaPedido respuesta = objectMapper.readValue(jsonResult, RespuestaPedido.class);

        Pedido pedidoGuardado = repositorioPedido.obtenerPorId(Integer.parseInt(respuesta.getValor().getId().toString()));

        Assertions.assertNotNull(pedidoGuardado);
        Assertions.assertEquals(comandoCalcularGuardarPedidoTestDataBuilder.getIdCliente(), pedidoGuardado.getIdCliente());
        Assertions.assertTrue(respuesta.getValor().getPrecioTotal().compareTo(pedidoGuardado.getPrecioTotal()) == 0);
    }
}
