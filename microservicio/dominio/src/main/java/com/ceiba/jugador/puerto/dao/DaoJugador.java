package com.ceiba.jugador.puerto.dao;

import com.ceiba.jugador.modelo.dto.DtoJugador;

import java.util.List;

public interface DaoJugador {

    /**
     * Permite listar jugadores
     * @return los jugadores
     */
    List<DtoJugador> listar();

    /**
     * Permite listar jugadores
     * @Param la posicion del jugador
     * @return los jugadores
     */
    List<DtoJugador> listarPorPosicion(String posicion);

    /**
     * Permite listar jugadores
     * @Param el pie habil del jugador
     * @return los jugadores
     */
    List<DtoJugador> listarPorPieHabil(String pieHabil);

    /**
     * Permite obtener un solo jugador
     * @return un jugador
     */
    DtoJugador obtenerPorId(Long id);
}
