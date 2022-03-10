package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;

public class ServicioEliminarJugador {

    public static final String NO_PUEDE_ELIMINAR_UN_JUGADOR_CON_FACTURA_PREVIA = "No puede eliminar un jugador con factura previa";
    private final RepositorioJugador repositorioJugador;

    public ServicioEliminarJugador(RepositorioJugador repositorioJugador) {
        this.repositorioJugador = repositorioJugador;
    }

    public void ejecutar(Long id) {
        validarExistenciaDeFactura(id);
        this.repositorioJugador.eliminar(id);
    }

    private void validarExistenciaDeFactura(Long id){
        boolean existe = this.repositorioJugador.existeJugadorConFactura(id);
        if (existe){
            throw new ExcepcionDuplicidad(NO_PUEDE_ELIMINAR_UN_JUGADOR_CON_FACTURA_PREVIA);
        }
    }

}
