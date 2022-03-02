package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;

public class ServicioActualizarJugador {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";

    private final RepositorioJugador repositorioJugador;

    public ServicioActualizarJugador(RepositorioJugador repositorioJugador) {
        this.repositorioJugador = repositorioJugador;
    }

    public void ejecutar(Jugador usuario) {
        validarExistenciaPrevia(usuario);
        this.repositorioJugador.actualizar(usuario);
    }

    private void validarExistenciaPrevia(Jugador jugador) {
        boolean existe = this.repositorioJugador.existePorId(jugador.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
