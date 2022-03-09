package com.ceiba.jugador.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.modelo.dto.DtoPosiciones;
import com.ceiba.jugador.servicio.ServicioObtenerEquipo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerEquipoJugadores {

    private final ServicioObtenerEquipo servicioObtenerEquipo;

    public ManejadorObtenerEquipoJugadores(ServicioObtenerEquipo servicioObtenerEquipo) {
        this.servicioObtenerEquipo = servicioObtenerEquipo;
    }

    public List<DtoJugador> ejecutar(String defensas, String mediocampistas, String delanteros) {
        return this.servicioObtenerEquipo.ejecutar(defensas, mediocampistas, delanteros);
    }
}
