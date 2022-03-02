package com.ceiba.jugador.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioObtenerEquipoTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando la cantidad de jugadores en el equipo supere el " +
            "maximo permitido")
    void deberiaLanzarUnaExepcionCuandoHayaMayorCantidadDeJugadoresPermitidos() {
        // arrange
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        DaoJugador daoJugador = Mockito.mock(DaoJugador.class);
        ServicioObtenerEquipo servicioObtenerEquipo = new ServicioObtenerEquipo(daoJugador);
        // act - assert
        BasePrueba.assertThrows(() -> servicioObtenerEquipo.ejecutar(4L,4L,4L), ExcepcionLongitudValor.class,"No puede sobrepasar la cantidad permitida de jugadores");
    }



}
