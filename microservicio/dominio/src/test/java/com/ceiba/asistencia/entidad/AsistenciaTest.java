package com.ceiba.asistencia.entidad;

import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.servicio.testdatabuilder.AsistenciaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsistenciaTest {

    @Test
    @DisplayName("Deberia crear una asistencia correctamente")
    void deberiaCrearUnaAsistenciaCorrectamente(){
        LocalDate date =LocalDate.now();

        Asistencia asistencia = new AsistenciaTestDataBuilder().build();

        assertEquals(date, asistencia.getFecha());
        assertEquals(10101010L, asistencia.getJugador().getDocumento());
    }
}
