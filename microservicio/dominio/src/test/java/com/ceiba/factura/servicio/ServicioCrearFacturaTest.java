package com.ceiba.factura.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.testdatabuilder.FacturaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearFacturaTest {

    @Test
    @DisplayName("Deberia Crear la factura de manera correcta")
    void deberiaCrearLaFacturaDeManeraCorrecta() {
        // arrange
        Factura factura = new FacturaTestDataBuilder().build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.existePorIdJugador(Mockito.anyInt())).thenReturn(false);
        Mockito.when(repositorioFactura.crear(factura)).thenReturn(10L);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
        // act
        Long idFactura = servicioCrearFactura.ejecutar(factura);
        //- assert
        assertEquals(10L,idFactura);
        Mockito.verify(repositorioFactura, Mockito.times(1)).crear(factura);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de una factura")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeUnaFacturaActiva() {
        // arrange
        Factura factura = new FacturaTestDataBuilder().build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.existePorDocumento(Mockito.anyLong())).thenReturn(true);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearFactura.ejecutar(factura), ExcepcionDuplicidad.class,"El usuario ya cuenta con una mensualidad vigente existe en el sistema");
    }

}
