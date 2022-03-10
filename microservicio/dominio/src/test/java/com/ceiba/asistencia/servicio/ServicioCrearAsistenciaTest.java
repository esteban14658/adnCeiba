package com.ceiba.asistencia.servicio;

import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.asistencia.servicio.testdatabuilder.AsistenciaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

public class ServicioCrearAsistenciaTest {

    @Test
    @DisplayName("Deberia crear una asistencia correctamente")
    void deberiaCrearUnaAsistenciaCorrectamente(){
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Asistencia asistencia = new AsistenciaTestDataBuilder().conJugador(jugador).build();

        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        doAnswer(invocation -> {
            Asistencia asistenciaArg = invocation.getArgument(0);
            assertNotNull(asistenciaArg);
            assertNull(asistenciaArg.getId());
            return null;
        }).when(repositorioAsistencia).crear(any(Asistencia.class));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia);

        assertDoesNotThrow(() -> servicioCrearAsistencia.ejecutar(asistencia));
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion si el jugador ya esta registrado esa fecha")
    void deberiaLanzarUnaExcepcionSiElJugadorYaEsteRegistradoEnEsaFecha(){
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        Asistencia asistencia = new AsistenciaTestDataBuilder().conJugador(jugador).build();

        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        doAnswer(invocation -> {
            Asistencia asistenciaArg = invocation.getArgument(0);
            assertNotNull(asistenciaArg);
            return null;
        }).when(repositorioAsistencia).crear(any(Asistencia.class));
        Mockito.when(repositorioAsistencia.registroDiario(Mockito.anyLong())).thenReturn(true);

        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia);

        assertThrows(ExcepcionDuplicidad.class, () -> servicioCrearAsistencia.ejecutar(asistencia));
    }
}
