package com.ceiba.jugador.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.servicio.ServicioObtenerEquipo;
import com.ceiba.jugador.servicio.ServicioObtenerPorIdJugador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerEquipoJugadores {

    private final ServicioObtenerEquipo servicioObtenerEquipo;

    public ManejadorObtenerEquipoJugadores(ServicioObtenerEquipo servicioObtenerEquipo) {
        this.servicioObtenerEquipo = servicioObtenerEquipo;
    }

    public List<DtoJugador> ejecutar(Long defensas, Long mediocampistas, Long delanteros) {
        return this.servicioObtenerEquipo.ejecutar(defensas, mediocampistas, delanteros);
    }
}
