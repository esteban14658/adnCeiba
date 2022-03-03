package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;

public class ServicioEliminarJugador {


    public static final String EL_JUGADOR_NO_EXISTE_EN_EL_SISTEMA = "El jugador no existe en el sistema";
    private final RepositorioJugador repositorioJugador;

    public ServicioEliminarJugador(RepositorioJugador repositorioJugador) {
        this.repositorioJugador = repositorioJugador;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioJugador.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id){
        boolean existe = this.repositorioJugador.existePorId(id);
        if (!existe){
            throw new ExcepcionSinDatos(EL_JUGADOR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
