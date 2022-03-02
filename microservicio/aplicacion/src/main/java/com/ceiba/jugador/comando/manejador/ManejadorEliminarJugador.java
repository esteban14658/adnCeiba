package com.ceiba.jugador.comando.manejador;

import com.ceiba.jugador.servicio.ServicioEliminarJugador;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarJugador implements ManejadorComando<Long> {

    private final ServicioEliminarJugador servicioEliminarJugador;

    public ManejadorEliminarJugador(ServicioEliminarJugador servicioEliminarJugador) {
        this.servicioEliminarJugador = servicioEliminarJugador;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarJugador.ejecutar(idUsuario);
    }
}
