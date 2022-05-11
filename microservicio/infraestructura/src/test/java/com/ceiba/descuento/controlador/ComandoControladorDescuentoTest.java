/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.descuento.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.restaurante.descuento.controlador.ComandoControladorDescuento;
import com.ceiba.restaurante.descuento.comando.ComandoDescuento;
import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import com.ceiba.restaurante.descuento.puerto.repositorio.RepositorioDescuento;
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
@WebMvcTest(ComandoControladorDescuento.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorDescuentoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioDescuento repositorioDescuento;

    @Test
    void crearDescuentoExitosa() throws Exception {
        ComandoDescuento comandoDescuentoTestDataBuilder = new ComandoDescuentoTestDataBuilder().crearPorDefecto().build();

        MvcResult resultado = mocMvc.perform(post("/descuento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoDescuentoTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        RespuestaDescuento respuesta = objectMapper.readValue(jsonResult, RespuestaDescuento.class);

        Descuento descuentoGuardado = repositorioDescuento.obtenerPorId(Integer.parseInt(respuesta.getValor().toString()));

        Assertions.assertNotNull(descuentoGuardado);
        Assertions.assertEquals(comandoDescuentoTestDataBuilder.getCantidadDias(), descuentoGuardado.getCantidadDias());
        Assertions.assertEquals(comandoDescuentoTestDataBuilder.getActivo(), descuentoGuardado.getActivo());
        Assertions.assertEquals(comandoDescuentoTestDataBuilder.getPorcentaje(), descuentoGuardado.getPorcentaje());
    }

    @Test
    void cambiarEstadoExitosa() throws Exception {

        Descuento descuentoInicial = repositorioDescuento.obtenerPorId(1);
        mocMvc.perform(post("/descuento/cambiarEstado/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Descuento descuento = repositorioDescuento.obtenerPorId(1);

        Assertions.assertNotNull(descuento);
        Assertions.assertEquals(descuentoInicial.getActivo(), !descuento.getActivo());
    }
}
