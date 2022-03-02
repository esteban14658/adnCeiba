package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ServicioObtenerEquipo {

    private final DaoJugador daoJugador;
    private final RepositorioJugador repositorioJugador;

    public ServicioObtenerEquipo(DaoJugador daoJugador, RepositorioJugador repositorioJugador) {
        this.daoJugador = daoJugador;
        this.repositorioJugador = repositorioJugador;
    }

    public List<DtoJugador> ejecutar(Long defensas, Long mediocampistas, Long delanteros) {
        String[] posiciones = new String[] {"Portero","Defensa", "Mediocampista", "Delantero"};
        Long[] keys = new Long[] {1L, defensas, mediocampistas, delanteros};
        Long sumatoria = 1L + defensas + mediocampistas + delanteros;
        if (sumatoria > 11L){
            throw new ExcepcionLongitudValor("No puede sobrepasar la cantidad permitida de jugadores");
        }
        List<DtoJugador> equipoA = new ArrayList<>();
        for (int i = 0; i < 4 ; i++){
            System.out.println(i);
            for (DtoJugador dtoJugador: obtenerJugadores(posiciones[i], keys[i])) {
                equipoA.add(dtoJugador);
            }
        }

        return equipoA;
    }

    private List<DtoJugador> obtenerJugadores(String posicion, Long cantidad){
        List<DtoJugador> jugadores = this.daoJugador.listarPorPosicion(posicion);
        List<DtoJugador> resultado = new ArrayList<>();
        for (int i = 0; i < cantidad; i++){
            int random = numeroAleatorioEnRango(0, cantidadDeLista(posicion));
            DtoJugador dtoJugador = jugadores.get(random);
            resultado.add(dtoJugador);
        }
        return resultado;
    }

    private int cantidadDeLista(String posicion){
        return this.daoJugador.listarPorPosicion(posicion).size();
    }

    private static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo);
    }
}
