package com.ceiba.factura.puerto.repositorio;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.jugador.modelo.entidad.Jugador;

public interface RepositorioFactura {

    /**
     * Permite crear un jugador
     * @param factura
     * @return el id generado
     */
    Long crear(Factura factura);

    /**
     * Permite actualizar un factura
     * @param factura
     */
    void actualizar(Factura factura);

    /**
     * Permite eliminar una factura
     * @param id
     */
    void eliminar(Integer id);

    /**
     * Permite validar si existe una factura con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Integer id);

    /**
     * Permite validar si existe una factura con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorDocumento(Long documento);

    /**
     * Permite validar si existe una factura con el id del jugador
     * @return si existe o no
     */
    boolean existePorIdJugador(Integer jugador);


}
