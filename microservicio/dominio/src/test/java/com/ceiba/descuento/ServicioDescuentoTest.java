package com.ceiba.descuento;

import com.ceiba.restaurante.descuento.modelo.dto.DescuentoActivoDTO;
import com.ceiba.restaurante.descuento.modelo.entidad.Descuento;
import com.ceiba.restaurante.descuento.puerto.repositorio.RepositorioDescuento;
import com.ceiba.restaurante.descuento.servicio.ServicioDescuento;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ServicioDescuentoTest {

    @Test
    void deberiaGenerarDescuentoYGuardar() {
        Descuento descuento = new DescuentoTestDataBuilder()
                .conDescuentoPorDefecto()
                .reconstruirSinId();

        RepositorioDescuento repositorioDescuento = Mockito.mock(RepositorioDescuento.class);
        Mockito.when(repositorioDescuento.guardar(Mockito.any())).thenReturn(1l);

        ServicioDescuento servicioDescuento = new ServicioDescuento(repositorioDescuento);

        Long idDescuentoCreada = servicioDescuento.guardar(descuento);

        ArgumentCaptor<Descuento> captor = ArgumentCaptor.forClass(Descuento.class);
        Mockito.verify(repositorioDescuento, Mockito.times(1)).guardar(captor.capture());
        Assertions.assertEquals(descuento, captor.getValue());
        Assertions.assertEquals(descuento.getCantidadDias(), captor.getValue().getCantidadDias());
        Assertions.assertEquals(descuento.getActivo(), captor.getValue().getActivo());
        Assertions.assertEquals(descuento.getPorcentaje(), captor.getValue().getPorcentaje());
        Assertions.assertEquals(1l, idDescuentoCreada);
    }

    @Test
    void obtenerActivos() {
        List<Descuento> list = new ArrayList<Descuento>();
        list.add(new DescuentoTestDataBuilder()
                .conDescuentoPorDefecto()
                .reconstruir());

        RepositorioDescuento repositorioDescuento = Mockito.mock(RepositorioDescuento.class);
        Mockito.when(repositorioDescuento.obtenerActivos()).thenReturn(list);
        ServicioDescuento servicioDescuento = new ServicioDescuento(repositorioDescuento);

        List<DescuentoActivoDTO> descuentoActivoDTOs = servicioDescuento.obtenerActivos();

        Mockito.verify(repositorioDescuento, Mockito.times(1)).obtenerActivos();
        Assertions.assertEquals(descuentoActivoDTOs.size(), list.size());
        Assertions.assertEquals(descuentoActivoDTOs.get(0).getCantidadDias(), list.get(0).getCantidadDias());
        Assertions.assertEquals(descuentoActivoDTOs.get(0).getId(), list.get(0).getId());
        Assertions.assertEquals(descuentoActivoDTOs.get(0).getPorcentaje(), list.get(0).getPorcentaje());
    }

    @Test
    void cambiarEstado() {
        Descuento descuento = new DescuentoTestDataBuilder()
                .conDescuentoPorDefecto()
                .reconstruir();

        RepositorioDescuento repositorioDescuento = Mockito.mock(RepositorioDescuento.class);
        Mockito.when(repositorioDescuento.obtenerPorId(descuento.getId())).thenReturn(descuento);
        descuento.cambiarEstado();
        Mockito.when(repositorioDescuento.cambiarEstado(descuento)).thenReturn(descuento.getId());
        
        ServicioDescuento servicioDescuento = new ServicioDescuento(repositorioDescuento);
        servicioDescuento.cambiarEstado(descuento.getId());

        ArgumentCaptor<Integer> captorObtener = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(repositorioDescuento, Mockito.times(1)).obtenerPorId(captorObtener.capture());
        ArgumentCaptor<Descuento> captor = ArgumentCaptor.forClass(Descuento.class);
        Mockito.verify(repositorioDescuento, Mockito.times(1)).cambiarEstado(captor.capture());
        Assertions.assertEquals(descuento.getId(), captorObtener.getValue());
        Assertions.assertEquals(descuento, captor.getValue());
        Assertions.assertEquals(descuento.getCantidadDias(), captor.getValue().getCantidadDias());
        Assertions.assertEquals(descuento.getActivo(), captor.getValue().getActivo());
        Assertions.assertEquals(descuento.getPorcentaje(), captor.getValue().getPorcentaje());  
    }
}
