package com.ceiba.asistencia.modelo.entidad;

import com.ceiba.jugador.modelo.entidad.Jugador;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Asistencia {

    private Long id;
    private LocalDate fecha;
    private Jugador jugador;

    public Asistencia(Long id, LocalDate fecha, Jugador jugador) {
        this.id = id;
        this.fecha = fecha;
        this.jugador = jugador;
    }
}
