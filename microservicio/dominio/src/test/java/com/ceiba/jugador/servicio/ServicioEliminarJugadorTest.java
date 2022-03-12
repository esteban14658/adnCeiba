package com.ceiba.jugador.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

public class ServicioEliminarJugadorTest {

    @Test
    @DisplayName("Deberia eliminar el jugador llamando al repositorio")
    void deberiaEliminarElJugadorLlamandoAlRepositorio() {
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        ServicioEliminarJugador servicioEliminarJugador = new ServicioEliminarJugador(repositorioJugador);

        servicioEliminarJugador.ejecutar(1L);

        Mockito.verify(repositorioJugador, Mockito.times(1)).eliminar(1l);

    }

    @Test
    @DisplayName("Deberia lanzar una excepcion si esta registrado en tabla factura")
    void deberiaLanzarUnaExcepcionSiEstaRegistradoEnTablaFactura(){
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);

        doAnswer(invocation -> {
            Jugador jugadorArg = invocation.getArgument(0);
            assertNotNull(jugadorArg);
            return null;
        }).when(repositorioJugador).crear(any(Jugador.class));
        Mockito.when(repositorioJugador.existeJugadorConFactura(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarJugador servicioEliminarJugador = new ServicioEliminarJugador(repositorioJugador);
        // act - assert
        assertThrows(ExcepcionDuplicidad.class, () -> servicioEliminarJugador.ejecutar(jugador.getId()));
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion si esta registrado en tabla asistencia")
    void deberiaLanzarUnaExcepcionSiEstaRegistradoEnTablaAsistencia(){
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);

        doAnswer(invocation -> {
            Jugador jugadorArg = invocation.getArgument(0);
            assertNotNull(jugadorArg);
            return null;
        }).when(repositorioJugador).crear(any(Jugador.class));
        Mockito.when(repositorioJugador.existeJugadorConAsistencias(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarJugador servicioEliminarJugador = new ServicioEliminarJugador(repositorioJugador);
        // act - assert
        assertThrows(ExcepcionDuplicidad.class, () -> servicioEliminarJugador.ejecutar(jugador.getId()));
    }

}
