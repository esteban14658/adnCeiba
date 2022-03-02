package com.ceiba.factura.puerto.dao;

import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.jugador.modelo.dto.DtoJugador;

import java.util.List;

public interface DaoFactura {

    /**
     * Permite listar facturas
     * @return los facturas
     */
    List<DtoFactura> listar();

}
