package com.ceiba.jugador.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearJugadorTest {

    @Test
    @DisplayName("Deberia Crear el jugador de manera correcta")
    void deberiaCrearElJugadorDeManeraCorrecta() {
        // arrange
        Jugador jugador = new JugadorTestDataBuilder().build();
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        Mockito.when(repositorioJugador.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioJugador.crear(jugador)).thenReturn(10L);
        ServicioCrearJugador servicioCrearJugador = new ServicioCrearJugador(repositorioJugador);
        // act
        Long idJugador = servicioCrearJugador.ejecutar(jugador);
        //- assert
        assertEquals(10L,idJugador);
        Mockito.verify(repositorioJugador, Mockito.times(1)).crear(jugador);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del jugador")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelJugador() {
        // arrange
        Jugador jugador = new JugadorTestDataBuilder().build();
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        Mockito.when(repositorioJugador.existePorDocumento(Mockito.anyLong())).thenReturn(true);
        ServicioCrearJugador servicioCrearJugador = new ServicioCrearJugador(repositorioJugador);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearJugador.ejecutar(jugador), ExcepcionDuplicidad.class,"El jugador ya existe en el sistema");
    }

}
