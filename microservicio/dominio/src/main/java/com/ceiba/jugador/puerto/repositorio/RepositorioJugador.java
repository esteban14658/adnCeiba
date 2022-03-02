package com.ceiba.jugador.puerto.repositorio;

import com.ceiba.jugador.modelo.entidad.Jugador;

public interface RepositorioJugador {
    /**
     * Permite crear un jugador
     * @param jugador
     * @return el id generado
     */
    Long crear(Jugador jugador);

    /**
     * Permite actualizar un jugador
     * @param jugador
     */
    void actualizar(Jugador jugador);

    /**
     * Permite eliminar un jugador
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un jugador con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un jugador con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

    /**
     * Permite validar si existe un jugador con dicho documento
     * @return si existe o no
     */
    boolean existePorDocumento(Long documento);

}
