package com.ceiba.factura.servicio;


import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doAnswer;

public class ServicioCrearFacturaTest {

    @Test
    @DisplayName("Deberia Crear la factura de manera correcta")
    void deberiaCrearLaFacturaDeManeraCorrecta() {
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Factura factura = new FacturaTestDataBuilder().conJugador(jugador).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        doAnswer(invocation -> {
            Factura facturaArg = invocation.getArgument(0);
            assertNotNull(facturaArg);
            assertNull(facturaArg.getId());
            return null;
        }).when(repositorioFactura).crear(any(Factura.class));
        ServicioCrearFactura service = new ServicioCrearFactura(repositorioFactura);

        assertDoesNotThrow(() -> service.ejecutar(factura, 3L));
    }

    @Test
    @DisplayName("Deberia Crear la factura de manera correcta cuando solo hay un mes")
    void deberiaCrearLaFacturaDeManeraCorrectaCuandoSoloEsUnMes() {
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Factura factura = new FacturaTestDataBuilder().conJugador(jugador).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        doAnswer(invocation -> {
            Factura facturaArg = invocation.getArgument(0);
            assertNotNull(facturaArg);
            assertNull(facturaArg.getId());
            return null;
        }).when(repositorioFactura).crear(any(Factura.class));
        ServicioCrearFactura service = new ServicioCrearFactura(repositorioFactura);

        assertDoesNotThrow(() -> service.ejecutar(factura, 1L));
    }

    @Test
    @DisplayName("Deberia Crear la factura de manera correcta cuando solo hay un mes")
    void deberiaCrearLaFacturaDeManeraCorrectaCuandoSonSeisMeses() {
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Factura factura = new FacturaTestDataBuilder().conJugador(jugador).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        doAnswer(invocation -> {
            Factura facturaArg = invocation.getArgument(0);
            assertNotNull(facturaArg);
            assertNull(facturaArg.getId());
            return null;
        }).when(repositorioFactura).crear(any(Factura.class));
        ServicioCrearFactura service = new ServicioCrearFactura(repositorioFactura);

        assertDoesNotThrow(() -> service.ejecutar(factura, 6L));
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de una factura")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeUnaFacturaActiva() {
        // arrange
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Factura factura = new FacturaTestDataBuilder().conJugador(jugador).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        doAnswer(invocation -> {
            // assert
            Factura facturaArg = invocation.getArgument(0);
            assertNotNull(facturaArg);
            return null;
        }).when(repositorioFactura).crear(any(Factura.class));
        //doReturn(Optional.of(factura)).when(repositorioFactura).existePorIdJugador(anyLong());
        Mockito.when(repositorioFactura.existePorIdJugador(Mockito.anyLong())).thenReturn(true);
        ServicioCrearFactura service = new ServicioCrearFactura(repositorioFactura);

        // act - assert
        assertThrows(ExcepcionSinDatos.class, () -> service.ejecutar(factura, 3L));
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se digite un mes no aceptado")
    void deberiaLanzarUnaExepcionCuandoSeDigiteUnMesNoAceptado() {
        // arrange
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Factura factura = new FacturaTestDataBuilder().conJugador(jugador).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        doAnswer(invocation -> {
            // assert
            Factura facturaArg = invocation.getArgument(0);
            assertNotNull(facturaArg);
            return null;
        }).when(repositorioFactura).crear(any(Factura.class));
        //doReturn(Optional.of(factura)).when(repositorioFactura).existePorIdJugador(anyLong());
        Mockito.when(repositorioFactura.existePorIdJugador(Mockito.anyLong())).thenReturn(false);
        ServicioCrearFactura service = new ServicioCrearFactura(repositorioFactura);

        // act - assert
        assertThrows(ExcepcionValorInvalido.class, () -> service.ejecutar(factura, 9L));
    }

}
