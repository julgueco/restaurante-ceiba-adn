/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.cliente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.restaurante.cliente.controlador.ComandoControladorCliente;
import com.ceiba.restaurante.cliente.comando.ComandoCliente;
import com.ceiba.restaurante.cliente.modelo.entidad.Cliente;
import com.ceiba.restaurante.cliente.puerto.repositorio.RepositorioCliente;
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
@WebMvcTest(ComandoControladorCliente.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioCliente repositorioCliente;

    @Test
    void crearClienteExitosa() throws Exception {
        ComandoCliente comandoClienteTestDataBuilder = new ComandoClienteTestDataBuilder().crearPorDefecto().build();

        MvcResult resultado = mocMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoClienteTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        RespuestaCliente respuesta = objectMapper.readValue(jsonResult, RespuestaCliente.class);

        Cliente clienteGuardado = repositorioCliente.obtenerPorId(Integer.parseInt(respuesta.getValor().toString()));
        
        Assertions.assertNotNull(clienteGuardado);
        Assertions.assertEquals(comandoClienteTestDataBuilder.getNombre(), clienteGuardado.getNombre());
        Assertions.assertEquals(comandoClienteTestDataBuilder.getNumeroDocumento(), clienteGuardado.getNumeroDocumento());
        Assertions.assertEquals(comandoClienteTestDataBuilder.getCelular(), clienteGuardado.getCelular());
        Assertions.assertEquals(comandoClienteTestDataBuilder.getCorreo(), clienteGuardado.getCorreo());
    }
}
