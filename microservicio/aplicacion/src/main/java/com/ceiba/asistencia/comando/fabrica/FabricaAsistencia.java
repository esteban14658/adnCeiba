package com.ceiba.asistencia.comando.fabrica;

import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FabricaAsistencia {

    public Asistencia crear(ComandoAsistencia comandoAsistencia){
        return new Asistencia(
                comandoAsistencia.getId(),
                LocalDate.now(),
                comandoAsistencia.getJugador()
        );
    }
}
