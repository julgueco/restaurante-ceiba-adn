/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.menu.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.restaurante.menu.controlador.ConsultaControladorMenu;
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
@WebMvcTest(ConsultaControladorMenu.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorMenuTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultarMenuActivos() throws Exception {

        mocMvc.perform(get("/menu/activo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.valor[0].id", is(1)))
                .andExpect(jsonPath("$.valor[0].nombre", is("Menu lunes")));
    }

    @Test
    void consultarMenus() throws Exception {

        mocMvc.perform(get("/menu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.valor[0].id", is(1)))
                .andExpect(jsonPath("$.valor[0].nombre", is("Menu lunes")))
                .andExpect(jsonPath("$.valor[0].activo", is(true)))
                .andExpect(jsonPath("$.valor[1].id", is(2)))
                .andExpect(jsonPath("$.valor[1].nombre", is("Menu jueves")))
                .andExpect(jsonPath("$.valor[1].activo", is(false)));
    }

    @Test
    void consultarMenusProdctos() throws Exception {

        mocMvc.perform(get("/menu/menuProducto")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.valor[0].id", is(1)))
                .andExpect(jsonPath("$.valor[0].idMenu", is(1)))
                .andExpect(jsonPath("$.valor[0].idProducto", is(1)));
    }

    @Test
    void consultarMenuProdctoPorId() throws Exception {

        mocMvc.perform(get("/menu/menuCompleto/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.valor.id", is(1)))
                .andExpect(jsonPath("$.valor.nombre", is("Menu lunes")))
                .andExpect(jsonPath("$.valor.activo", is(true)))
                .andExpect(jsonPath("$.valor.productos[0].id", is(1)))
                .andExpect(jsonPath("$.valor.productos[0].nombre", is("Papa a la francesa")))
                .andExpect(jsonPath("$.valor.productos[0].precio", is(3000.00)))
                .andExpect(jsonPath("$.valor.productos[1].id", is(2)))
                .andExpect(jsonPath("$.valor.productos[1].nombre", is("Carne asada")))
                .andExpect(jsonPath("$.valor.productos[1].precio", is(4000.00)))
                .andExpect(jsonPath("$.valor.productos[2].id", is(3)))
                .andExpect(jsonPath("$.valor.productos[2].nombre", is("Crema de zanahoria")))
                .andExpect(jsonPath("$.valor.productos[2].precio", is(3000.00)));
    }
}
