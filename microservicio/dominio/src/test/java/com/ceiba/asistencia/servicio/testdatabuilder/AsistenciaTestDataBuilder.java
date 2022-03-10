package com.ceiba.asistencia.servicio.testdatabuilder;

import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;

import java.time.LocalDate;

public class AsistenciaTestDataBuilder {

    private Long id;
    private LocalDate fecha;
    private Jugador jugador;

    public AsistenciaTestDataBuilder() {
        this.fecha = LocalDate.now();
        this.jugador = new JugadorTestDataBuilder().build();
    }

    public AsistenciaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public AsistenciaTestDataBuilder conFecha(LocalDate fecha){
        this.fecha = fecha;
        return this;
    }

    public AsistenciaTestDataBuilder conJugador(Jugador jugador) {
        this.jugador = jugador;
        return this;
    }

    public Asistencia build(){
        return new Asistencia(id, fecha, jugador);
    }
}
