package com.ceiba.factura.comando.fabrica;

import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import org.springframework.stereotype.Component;

@Component
public class FabricaFactura {

    public Factura crear(ComandoFactura comandoFactura){
        return new Factura(
              comandoFactura.getId(),
              comandoFactura.getValor(),
              comandoFactura.getFechaIngreso(),
              comandoFactura.getFechaCaducidad(),
              mapToEntity(comandoFactura.getJugador()),
              comandoFactura.getEstado(),
              comandoFactura.getDescripcion()
        );
    }

    private Jugador mapToEntity(final DtoJugador dtoJugador){
        final Jugador jugador = new Jugador(
                dtoJugador.getId(),
                dtoJugador.getDocumento(),
                dtoJugador.getNombre(),
                dtoJugador.getApellido(),
                dtoJugador.getFechaNacimiento(),
                dtoJugador.getPeso(),
                dtoJugador.getAltura(),
                dtoJugador.getPosicion(),
                dtoJugador.getPieHabil()
        );
        return jugador;
    }

}
