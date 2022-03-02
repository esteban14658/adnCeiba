package com.ceiba.jugador.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.jugador.comando.ComandoJugador;
import com.ceiba.jugador.comando.fabrica.FabricaJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.servicio.ServicioCrearJugador;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearJugador implements ManejadorComandoRespuesta<ComandoJugador, ComandoRespuesta<Long>> {

    private final FabricaJugador fabricaJugador;
    private final ServicioCrearJugador servicioCrearJugador;

    public ManejadorCrearJugador(FabricaJugador fabricaJugador, ServicioCrearJugador servicioCrearJugador) {
        this.fabricaJugador = fabricaJugador;
        this.servicioCrearJugador = servicioCrearJugador;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoJugador comandoJugador) {
        Jugador jugador = this.fabricaJugador.crear(comandoJugador);
        return new ComandoRespuesta<>(this.servicioCrearJugador.ejecutar(jugador));
    }
}
