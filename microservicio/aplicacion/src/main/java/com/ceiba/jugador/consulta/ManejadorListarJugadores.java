package com.ceiba.jugador.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarJugadores {

    private final DaoJugador daoJugador;

    public ManejadorListarJugadores(DaoJugador daoJugador){
        this.daoJugador = daoJugador;
    }

    public List<DtoJugador> ejecutar(Integer cantidad, Integer pagina){ return this.daoJugador.listar(cantidad, pagina); }
}
