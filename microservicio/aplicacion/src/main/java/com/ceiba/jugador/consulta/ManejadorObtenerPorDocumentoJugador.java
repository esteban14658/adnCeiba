package com.ceiba.jugador.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.servicio.ServicioObtenerPorDocumentoJugador;
import org.springframework.stereotype.Component;


@Component
public class ManejadorObtenerPorDocumentoJugador {

    private final ServicioObtenerPorDocumentoJugador servicioObtenerPorDocumentoJugador;

    public ManejadorObtenerPorDocumentoJugador(ServicioObtenerPorDocumentoJugador servicioObtenerPorDocumentoJugador){
        this.servicioObtenerPorDocumentoJugador = servicioObtenerPorDocumentoJugador;
    }

    public DtoJugador ejecutar(Long documento){
        return this.servicioObtenerPorDocumentoJugador.ejecutar(documento);
    }

}
