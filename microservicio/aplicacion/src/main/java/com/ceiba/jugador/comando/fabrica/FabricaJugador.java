package com.ceiba.jugador.comando.fabrica;

import com.ceiba.jugador.comando.ComandoJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import org.springframework.stereotype.Component;

@Component
public class FabricaJugador {

    public Jugador crear(ComandoJugador comandoJugador) {
        return new Jugador(
                comandoJugador.getId(),
                comandoJugador.getDocumento(),
                comandoJugador.getNombre(),
                comandoJugador.getApellido(),
                comandoJugador.getFechaNacimiento(),
                comandoJugador.getPeso(),
                comandoJugador.getAltura(),
                comandoJugador.getPosicion(),
                comandoJugador.getPieHabil()
        );
    }

}
