package com.ceiba.asistencia.servicio;

import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearAsistencia {

    public static final String NO_SE_PUEDE_REGISTRAR_NUEVAMENTE_HOY = "No se puede registrar nuevamente hoy";
    private final RepositorioAsistencia repositorioAsistencia;

    public ServicioCrearAsistencia(RepositorioAsistencia repositorioAsistencia) {
        this.repositorioAsistencia = repositorioAsistencia;
    }

    public Long ejecutar(Asistencia asistencia){
        validarAsistenciaDeHoy(asistencia);
        return this.repositorioAsistencia.crear(asistencia);
    }

    private void validarAsistenciaDeHoy(Asistencia asistencia){
        boolean existe = this.repositorioAsistencia.registroDiario(asistencia.getJugador().getId());
        if (existe){
            throw new ExcepcionDuplicidad(NO_SE_PUEDE_REGISTRAR_NUEVAMENTE_HOY);
        }
    }
}
