/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceiba.producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.restaurante.producto.controlador.ComandoControladorProducto;
import com.ceiba.restaurante.producto.comando.ComandoCambiarPrecioProducto;
import com.ceiba.restaurante.producto.comando.ComandoProducto;
import com.ceiba.restaurante.producto.modelo.entidad.Producto;
import com.ceiba.restaurante.producto.puerto.repositorio.RepositorioProducto;
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
@WebMvcTest(ComandoControladorProducto.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorProductoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioProducto repositorioProducto;

    @Test
    void crearProductoExitosa() throws Exception {
        ComandoProducto comandoProductoTestDataBuilder = new ComandoProductoTestDataBuilder().crearPorDefecto().build();

        MvcResult resultado = mocMvc.perform(post("/producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProductoTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        RespuestaProducto respuesta = objectMapper.readValue(jsonResult, RespuestaProducto.class);

        Producto productoGuardado = repositorioProducto.obtenerPorId(Integer.parseInt(respuesta.getValor().toString()));

        Assertions.assertNotNull(productoGuardado);
        Assertions.assertEquals(comandoProductoTestDataBuilder.getNombre(), productoGuardado.getNombre());
        Assertions.assertTrue(comandoProductoTestDataBuilder.getPrecio().compareTo(productoGuardado.getPrecio()) == 0);
    }

    @Test
    void cambiarPrecioProductoExitosa() throws Exception {

        ComandoCambiarPrecioProducto comandoCambiarPrecioProductoTestDataBuilder = new ComandoCambiarPrecioProductoTestDataBuilder().crearPorDefecto().build();

        mocMvc.perform(post("/producto/cambiarPrecio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCambiarPrecioProductoTestDataBuilder)))
                .andExpect(status().isOk());

        Producto producto = repositorioProducto.obtenerPorId(1);

        Assertions.assertNotNull(producto);
        Assertions.assertTrue(comandoCambiarPrecioProductoTestDataBuilder.getPrecio().compareTo(producto.getPrecio()) == 0);
    }
}
