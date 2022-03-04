package com.ceiba.jugador.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.modelo.dto.DtoPosiciones;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicioObtenerEquipoTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando la cantidad de jugadores en el equipo supere el " +
            "maximo permitido")
    void deberiaLanzarUnaExepcionCuandoHayaMayorCantidadDeJugadoresPermitidos() {
        // arrange
        DaoJugador daoJugador = Mockito.mock(DaoJugador.class);
        DtoPosiciones dtoPosiciones = new DtoPosiciones(4L, 4L, 4L);
        ServicioObtenerEquipo servicioObtenerEquipo = new ServicioObtenerEquipo(daoJugador);
        // act - assert
        BasePrueba.assertThrows(() -> servicioObtenerEquipo.ejecutar(dtoPosiciones), ExcepcionLongitudValor.class,"No puede sobrepasar la cantidad permitida de jugadores");
    }

    @Test
    @DisplayName("Deberia obtener un equipo de manera correcta")
    void deberiaObtenerUnEquipoDeManeraCorrecta() {
        List<DtoJugador> listaJugadores = new JugadorTestDataBuilder().listaDeJugadores();
        DaoJugador daoJugador = Mockito.mock(DaoJugador.class);
        DtoPosiciones dtoPosiciones = new DtoPosiciones(4L, 4L, 2L);
        Mockito.when(daoJugador.listarPorPosicion("Portero")).thenReturn(listaJugadores);
        Mockito.when(daoJugador.listarPorPosicion("Defensa")).thenReturn(listaJugadores);
        Mockito.when(daoJugador.listarPorPosicion("Mediocampista")).thenReturn(listaJugadores);
        Mockito.when(daoJugador.listarPorPosicion("Delantero")).thenReturn(listaJugadores);
        ServicioObtenerEquipo servicioObtenerEquipo = new ServicioObtenerEquipo(daoJugador);
        List<DtoJugador> listaJugadoresRetornados = servicioObtenerEquipo.ejecutar(dtoPosiciones);

        assertTrue(!listaJugadoresRetornados.isEmpty());

    }

}
