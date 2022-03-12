package com.ceiba.factura.consulta;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarJugadoresSinFactura {

    private final DaoJugador daoJugador;

    public ManejadorListarJugadoresSinFactura(DaoJugador daoJugador) {
        this.daoJugador = daoJugador;
    }

    public List<DtoJugador> ejecutar(){
        return this.daoJugador.listarJugadoresSinFactura();
    }
}
