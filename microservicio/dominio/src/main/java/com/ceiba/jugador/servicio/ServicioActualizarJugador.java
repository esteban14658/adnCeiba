package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;

public class ServicioActualizarJugador {

    private static final String EL_JUGADOR_NO_EXISTE_EN_EL_SISTEMA = "El jugador no existe en el sistema";

    private final RepositorioJugador repositorioJugador;

    public ServicioActualizarJugador(RepositorioJugador repositorioJugador) {
        this.repositorioJugador = repositorioJugador;
    }

    public void ejecutar(Jugador jugador) {
        validarExistenciaPrevia(jugador);
        this.repositorioJugador.actualizar(jugador);
    }

    private void validarExistenciaPrevia(Jugador jugador) {
        boolean existe = this.repositorioJugador.existePorId(jugador.getId());
        if(!existe) {
            throw new ExcepcionSinDatos(EL_JUGADOR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
