package com.ceiba.jugador.comando.manejador;

import com.ceiba.jugador.comando.ComandoJugador;
import com.ceiba.jugador.comando.fabrica.FabricaJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.servicio.ServicioActualizarJugador;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarJugador implements ManejadorComando<ComandoJugador> {

    private final FabricaJugador fabricaJugador;
    private final ServicioActualizarJugador servicioActualizarJugador;

    public ManejadorActualizarJugador(FabricaJugador fabricaJugador, ServicioActualizarJugador servicioActualizarJugador) {
        this.fabricaJugador = fabricaJugador;
        this.servicioActualizarJugador = servicioActualizarJugador;
    }

    public void ejecutar(ComandoJugador comandoJugador) {
        Jugador jugador = this.fabricaJugador.crear(comandoJugador);
        this.servicioActualizarJugador.ejecutar(jugador);
    }
}
