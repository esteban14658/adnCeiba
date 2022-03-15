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
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;


import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

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
    @DisplayName("Deberia devolver el valor cuando se ingresa el plan mensual")
    void deberiaDevolverElValorCuandoSeIngresaElPlanMensual() {
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Factura factura = new FacturaTestDataBuilder().conJugador(jugador).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
        ArgumentCaptor<Factura> facturaArgumentCaptor = ArgumentCaptor.forClass(Factura.class);
        servicioCrearFactura.ejecutar(factura, 1L);
        verify(repositorioFactura).crear(facturaArgumentCaptor.capture());
        Factura capturarValor = facturaArgumentCaptor.getValue();

        assertEquals(100000, capturarValor.getValor());

    }

    @Test
    @DisplayName("Deberia devolver el valor cuando se ingresa el plan trimestral")
    void deberiaDevolverElValorCuandoSeIngresaElPlanTrimestral() {
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Factura factura = new FacturaTestDataBuilder().conJugador(jugador).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
        ArgumentCaptor<Factura> facturaArgumentCaptor = ArgumentCaptor.forClass(Factura.class);
        servicioCrearFactura.ejecutar(factura, 3L);
        verify(repositorioFactura).crear(facturaArgumentCaptor.capture());
        Factura capturarValor = facturaArgumentCaptor.getValue();

        assertEquals(255000, capturarValor.getValor());

    }

    @Test
    @DisplayName("Deberia devolver el valor cuando se ingresa el plan semestral")
    void deberiaDevolverElValorCuandoSeIngresaElPlanSemestral() {
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Factura factura = new FacturaTestDataBuilder().conJugador(jugador).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
        ArgumentCaptor<Factura> facturaArgumentCaptor = ArgumentCaptor.forClass(Factura.class);
        servicioCrearFactura.ejecutar(factura, 6L);
        verify(repositorioFactura).crear(facturaArgumentCaptor.capture());
        Factura capturarValor = facturaArgumentCaptor.getValue();

        assertEquals(420000, capturarValor.getValor());

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
        Mockito.when(repositorioFactura.existePorIdJugador(Mockito.anyLong())).thenReturn(false);
        ServicioCrearFactura service = new ServicioCrearFactura(repositorioFactura);

        // act - assert
        assertThrows(ExcepcionValorInvalido.class, () -> service.ejecutar(factura, 9L));
    }

}
