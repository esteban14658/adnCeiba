package com.ceiba.jugador.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioObtenerPorDocumentoJugadorTest {

    public static final long DOCUMENTO = 80808080L;

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando no se valide la existencia del jugador")
    void deberiaLanzarUnaExepcionCuandoNoSeValideLaExistenciaDelJugador() {
        // arrange
        Jugador jugador = new JugadorTestDataBuilder().build();
        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        DaoJugador daoJugador = Mockito.mock(DaoJugador.class);
        Mockito.when(repositorioJugador.existePorDocumento(Mockito.anyLong())).thenReturn(true);
        ServicioObtenerPorDocumentoJugador servicioObtenerPorDocumentoJugador = new ServicioObtenerPorDocumentoJugador(daoJugador ,repositorioJugador);
        // act - assert
        BasePrueba.assertThrows(() -> servicioObtenerPorDocumentoJugador.ejecutar(jugador.getId()), ExcepcionSinDatos.class,"El usuario no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia obtener un jugador a traves de su id")
    void deberiaObtenerUnJugadorPorSuId(){
        // arrange
        DtoJugador dtoJugador = new JugadorTestDataBuilder().dtoJugador();

        RepositorioJugador repositorioJugador = Mockito.mock(RepositorioJugador.class);
        DaoJugador daoJugador = Mockito.mock(DaoJugador.class);

        Mockito.when(repositorioJugador.existePorDocumento(DOCUMENTO)).thenReturn(true);
        Mockito.when(daoJugador.obtenerPorDocumento(DOCUMENTO)).thenReturn(dtoJugador);
        ServicioObtenerPorDocumentoJugador servicioObtenerPorDocumentoJugador = new ServicioObtenerPorDocumentoJugador(daoJugador, repositorioJugador);
        DtoJugador dtoJugadorReturned = servicioObtenerPorDocumentoJugador.ejecutar(DOCUMENTO);

        assertEquals(dtoJugadorReturned, dtoJugador);
    }

}
