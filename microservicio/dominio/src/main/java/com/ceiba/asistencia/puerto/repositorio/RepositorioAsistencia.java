package com.ceiba.asistencia.puerto.repositorio;

import com.ceiba.asistencia.modelo.entidad.Asistencia;

public interface RepositorioAsistencia {

    /**
     * Permite crear un asistencia
     * @param asistencia
     * @return el id generado
     */
    Long crear(Asistencia asistencia);

    /**
     * Permite verificar si el jugador ya se registro en la asistencia
     * @param id
     * @return si esta registrado o no
     */
    boolean registroDiario(Long id);
}
