package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;


public class ServicioCrearJugador {

    private static final String EL_JUGADOR_YA_EXISTE_EN_EL_SISTEMA = "El jugador ya existe en el sistema";

    private final RepositorioJugador repositorioJugador;

    public ServicioCrearJugador(RepositorioJugador repositorioJugador) {
        this.repositorioJugador = repositorioJugador;
    }

    public Long ejecutar(Jugador jugador) {
        validarExistenciaPrevia(jugador);
        return this.repositorioJugador.crear(jugador);
    }

    private void validarExistenciaPrevia(Jugador jugador) {
        boolean existe = this.repositorioJugador.existePorDocumento(jugador.getDocumento());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_JUGADOR_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
