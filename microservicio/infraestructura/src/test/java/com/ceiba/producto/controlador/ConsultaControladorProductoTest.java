/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.restaurante.producto.controlador.ConsultaControladorProducto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author julian.guerrero
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorProducto.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorProductoTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultarMenus() throws Exception {

        mocMvc.perform(get("/producto")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.valor[0].id", is(1)))
                .andExpect(jsonPath("$.valor[0].nombre", is("Papa a la francesa")))
                .andExpect(jsonPath("$.valor[0].precio", is(3000.00)))
                .andExpect(jsonPath("$.valor[1].id", is(2)))
                .andExpect(jsonPath("$.valor[1].nombre", is("Carne asada")))
                .andExpect(jsonPath("$.valor[1].precio", is(4000.00)))
                .andExpect(jsonPath("$.valor[2].id", is(3)))
                .andExpect(jsonPath("$.valor[2].nombre", is("Crema de zanahoria")))
                .andExpect(jsonPath("$.valor[2].precio", is(3000.00)));
    }
}
