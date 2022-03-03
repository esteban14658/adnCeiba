package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;

public class ServicioObtenerPorDocumentoJugador {

    private static final String EL_JUGADOR_NO_EXISTE_EN_EL_SISTEMA = "El jugador no existe en el sistema";

    private final DaoJugador daoJugador;
    private final RepositorioJugador repositorioJugador;

    public ServicioObtenerPorDocumentoJugador(DaoJugador daoJugador, RepositorioJugador repositorioJugador) {
        this.daoJugador = daoJugador;
        this.repositorioJugador = repositorioJugador;
    }

    public DtoJugador ejecutar(Long documento){
        validarExistenciaPrevia(documento);
        return this.daoJugador.obtenerPorDocumento(documento);
    }

    private void validarExistenciaPrevia(Long documento) {
        boolean existe = this.repositorioJugador.existePorDocumento(documento);
        if(!existe) {
            throw new ExcepcionSinDatos(EL_JUGADOR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
