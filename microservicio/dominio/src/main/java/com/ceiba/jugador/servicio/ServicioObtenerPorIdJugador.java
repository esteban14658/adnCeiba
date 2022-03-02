package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;

public class ServicioObtenerPorIdJugador {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";

    private final DaoJugador daoJugador;
    private final RepositorioJugador repositorioJugador;

    public ServicioObtenerPorIdJugador(DaoJugador daoJugador, RepositorioJugador repositorioJugador) {
        this.daoJugador = daoJugador;
        this.repositorioJugador = repositorioJugador;
    }

    public DtoJugador ejecutar(Long id){
        validarExistenciaPrevia(id);
        return this.daoJugador.obtenerPorId(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioJugador.existePorId(id);
        if(!existe) {
            throw new ExcepcionSinDatos(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
