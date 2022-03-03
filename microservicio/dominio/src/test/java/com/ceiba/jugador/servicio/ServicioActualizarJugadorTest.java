package com.ceiba.jugador.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarJugadorTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del jugador")
    void deberiaValidarLaExistenciaPreviaDelJugador() {
        // arrange
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        Mockito.when(repositorioJugador.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarJugador servicioActualizarJugador = new ServicioActualizarJugador(repositorioJugador);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarJugador.ejecutar(jugador), ExcepcionSinDatos.class,"El jugador no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        Mockito.when(repositorioJugador.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarJugador servicioActualizarJugador = new ServicioActualizarJugador(repositorioJugador);
        // act
        servicioActualizarJugador.ejecutar(jugador);
        //assert
        Mockito.verify(repositorioJugador,Mockito.times(1)).actualizar(jugador);
    }

}
