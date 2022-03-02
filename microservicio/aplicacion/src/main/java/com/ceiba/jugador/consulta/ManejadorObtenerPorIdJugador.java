package com.ceiba.jugador.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.servicio.ServicioObtenerPorIdJugador;
import org.springframework.stereotype.Component;


@Component
public class ManejadorObtenerPorIdJugador {

    private final ServicioObtenerPorIdJugador servicioObtenerPorIdJugador;

    public ManejadorObtenerPorIdJugador(ServicioObtenerPorIdJugador servicioObtenerPorIdJugador){
        this.servicioObtenerPorIdJugador = servicioObtenerPorIdJugador;
    }

    public DtoJugador ejecutar(Long id){
        return this.servicioObtenerPorIdJugador.ejecutar(id);
    }

}
