package com.ceiba.asistencia.puerto.dao;

import com.ceiba.asistencia.modelo.dto.DtoAsistencia;

import java.util.List;

public interface DaoAsitencia {

    /**
     * Permite listar asistencias
     * @return los asistencias
     */
    List<DtoAsistencia> listar();

}
