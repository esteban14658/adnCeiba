package com.ceiba.jugador.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarJugadoresSinAsistencia {

    private final DaoJugador daoJugador;

    public ManejadorListarJugadoresSinAsistencia(DaoJugador daoJugador) {
        this.daoJugador = daoJugador;
    }

    public List<DtoJugador> ejecutar(){ return this.daoJugador.listarSinAsistencias(); }
}
