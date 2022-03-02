package com.ceiba.jugador.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarJugadoresPorPieHabil {

    private final DaoJugador daoJugador;

    public ManejadorListarJugadoresPorPieHabil(DaoJugador daoJugador){
        this.daoJugador = daoJugador;
    }

    public List<DtoJugador> ejecutar(String pieHabil){
        return this.daoJugador.listarPorPieHabil(pieHabil);
    }
}
