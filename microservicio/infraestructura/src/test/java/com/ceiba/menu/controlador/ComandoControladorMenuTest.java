/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.menu.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.restaurante.menu.comando.ComandoMenu;
import com.ceiba.restaurante.menu.comando.ComandoMenuProducto;
import com.ceiba.restaurante.menu.controlador.ComandoControladorMenu;
import com.ceiba.restaurante.menu.modelo.entidad.Menu;
import com.ceiba.restaurante.menu.modelo.entidad.MenuProducto;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenu;
import com.ceiba.restaurante.menu.puerto.repositorio.RepositorioMenuProducto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
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
@WebMvcTest(ComandoControladorMenu.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorMenuTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioMenu repositorioMenu;

    @Autowired
    private RepositorioMenuProducto repositorioMenuProducto;

    @Test
    void crearMenuExitosa() throws Exception {
        ComandoMenu comandoMenuTestDataBuilder = new ComandoMenuTestDataBuilder().crearPorDefecto().build();

        MvcResult resultado = mocMvc.perform(post("/menu")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoMenuTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        RespuestaMenu respuesta = objectMapper.readValue(jsonResult, RespuestaMenu.class);

        Menu menuGuardado = repositorioMenu.obtenerPorId(Integer.parseInt(respuesta.getValor().toString()));

        Assertions.assertNotNull(menuGuardado);
        Assertions.assertEquals("Menu martes", menuGuardado.getNombre());
        Assertions.assertEquals(false, menuGuardado.getActivo());
    }

    @Test
    void cambiarEstadoMenuExitosa() throws Exception {

        Menu menuInicial = repositorioMenu.obtenerPorId(1);
        mocMvc.perform(post("/menu/cambiarEstado/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Menu menu = repositorioMenu.obtenerPorId(1);

        Assertions.assertNotNull(menu);
        Assertions.assertEquals(menuInicial.getActivo(), !menu.getActivo());
    }

    @Test
    void crearMenuProductoExitosa() throws Exception {
        ComandoMenuProducto comandoMenuTestDataBuilder = new ComandoMenuProductoTestDataBuilder().crearPorDefecto().build();

        MvcResult resultado = mocMvc.perform(post("/menu/menuProducto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoMenuTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        RespuestaMenu respuesta = objectMapper.readValue(jsonResult, RespuestaMenu.class);
        Integer id = Integer.parseInt(respuesta.getValor().toString());

        List<MenuProducto> menusProductosGuardados = repositorioMenuProducto.obtenerTodos();

        MenuProducto menuProducto = menusProductosGuardados.stream().filter(menuProd -> menuProd.getId().equals(id)).findFirst().get();

        Assertions.assertNotNull(menuProducto);
        Assertions.assertTrue(menuProducto.getId().equals(id));
        Assertions.assertTrue(menuProducto.getIdMenu().equals(comandoMenuTestDataBuilder.getIdMenu()));
        Assertions.assertTrue(menuProducto.getIdProducto().equals(comandoMenuTestDataBuilder.getIdProducto()));
    }
}
