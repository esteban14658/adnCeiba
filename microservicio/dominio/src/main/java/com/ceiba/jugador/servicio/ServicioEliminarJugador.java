package com.ceiba.jugador.servicio;

import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;

public class ServicioEliminarJugador {

    private final RepositorioJugador repositorioJugador;

    public ServicioEliminarJugador(RepositorioJugador repositorioJugador) {
        this.repositorioJugador = repositorioJugador;
    }

    public void ejecutar(Long id) {
        this.repositorioJugador.eliminar(id);
    }
}
