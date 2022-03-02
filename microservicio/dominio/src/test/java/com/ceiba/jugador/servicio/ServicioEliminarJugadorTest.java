package com.ceiba.jugador.servicio;

import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarJugadorTest {

    @Test
    @DisplayName("Deberia eliminar el jugador llamando al repositorio")
    void deberiaEliminarElJugadorLlamandoAlRepositorio() {
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        ServicioEliminarJugador servicioEliminarJugador = new ServicioEliminarJugador(repositorioJugador);

        servicioEliminarJugador.ejecutar(1l);

        Mockito.verify(repositorioJugador, Mockito.times(1)).eliminar(1l);

    }

}
