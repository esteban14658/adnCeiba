package com.ceiba.factura.puerto.repositorio;

import com.ceiba.factura.modelo.entidad.Factura;

public interface RepositorioFactura{

    /**
     * Permite crear una factura
     * @param factura
     * @return el id generado
     */
    Long crear(Factura factura);

    /**
     * Permite eliminar una factura
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una factura con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

    /**
     * Permite validar si existe una factura con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorDocumento(Long documento);

    /**
     * Permite validar si existe una factura con el id del jugador
     * @return si existe o no
     */
    boolean existePorIdJugador(Long jugador);
}
