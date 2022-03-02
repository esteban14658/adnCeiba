package com.ceiba.jugador.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.servicio.ServicioObtenerPorIdJugador;
import org.springframework.stereotype.Component;


@Component
public class ManejadorObtenerPorIdJugador {

    private final DaoJugador daoJugador;
    private final ServicioObtenerPorIdJugador servicioObtenerPorIdJugador;

    public ManejadorObtenerPorIdJugador(DaoJugador daoJugador, ServicioObtenerPorIdJugador servicioObtenerPorIdJugador){
        this.servicioObtenerPorIdJugador = servicioObtenerPorIdJugador;
        this.daoJugador = daoJugador;
    }

    public DtoJugador ejecutar(Long id){
        return this.servicioObtenerPorIdJugador.ejecutar(id);
    }

}
