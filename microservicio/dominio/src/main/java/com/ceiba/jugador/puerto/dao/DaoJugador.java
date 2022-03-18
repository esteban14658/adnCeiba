package com.ceiba.jugador.puerto.dao;

import com.ceiba.jugador.modelo.dto.DtoJugador;

import java.util.List;

public interface DaoJugador {

    /**
     * Permite listar jugadores
     * @param cantidad hace referencia al numero de datos solicitados
     * @param pagina hace referencia al salto en los datos solicitados
     * @return los jugadores
     */
    List<DtoJugador> listar(Integer cantidad, Integer pagina);

    /**
     * Permite listar jugadores
     * @Param la posicion del jugador
     * @return los jugadores
     */
    List<DtoJugador> listarPorPosicion(String posicion);

    /**
     * Permite listar jugadores
     * @return los jugadores
     */
    List<DtoJugador> listarJugadoresSinFactura();

    /**
     * Permite listar asistencias
     * @return los asistencias
     */
    List<DtoJugador> listarSinAsistencias();

    /**
     * Permite listar por categoras
     * @return lista por año de nacimiento
     */
    List<DtoJugador> listarPorCategoria(String fecha);

    /**
     * Permite obtener un solo jugador
     * @return un jugador
     */
    DtoJugador obtenerPorDocumento(Long documento);
}
