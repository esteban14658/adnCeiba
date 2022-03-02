package com.ceiba.jugador.entidad;

import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    @DisplayName("Deberia crear correctamente el jugador")
    void DeberiaCrearCorrectamenteElJugador(){
        // Arrange
        LocalDate date = LocalDate.now();
        // act
        Jugador jugador = new JugadorTestDataBuilder().conId(1L).build();
        // assert
        assertEquals(1L, jugador.getId());
        assertEquals(10101010L, jugador.getDocumento());
        assertEquals("Juanito", jugador.getNombre());
        assertEquals("Alimaña", jugador.getApellido());
        assertEquals(LocalDate.parse("2022-02-14"), jugador.getFechaNacimiento());
        assertEquals((float) 54.6, jugador.getPeso());
        assertEquals((float) 1.65, jugador.getAltura());
        assertEquals("Delantero", jugador.getPosicion());
        assertEquals("Derecho", jugador.getPieHabil());
    }

}
