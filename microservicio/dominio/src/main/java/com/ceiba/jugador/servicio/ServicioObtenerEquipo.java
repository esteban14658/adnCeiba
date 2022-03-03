package com.ceiba.jugador.servicio;

import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class ServicioObtenerEquipo {

    public static final long CANTIDAD_MAXIMA_JUGADORES_PERMITIDA = 11L;
    private final DaoJugador daoJugador;

    public ServicioObtenerEquipo(DaoJugador daoJugador) {
        this.daoJugador = daoJugador;
    }

    public List<DtoJugador> ejecutar(Long defensas, Long mediocampistas, Long delanteros) {
        String[] posiciones = new String[] {"Portero","Defensa", "Mediocampista", "Delantero"};
        List<String> listaPosiciones = Arrays.asList("Portero","Defensa", "Mediocampista", "Delantero");
        Long[] keys = new Long[] {1L, defensas, mediocampistas, delanteros};
        Long sumatoria = 1L + defensas + mediocampistas + delanteros;
        if (sumatoria > CANTIDAD_MAXIMA_JUGADORES_PERMITIDA){
            throw new ExcepcionLongitudValor("No puede sobrepasar la cantidad permitida de jugadores");
        }
        List<DtoJugador> equipoA = new ArrayList<>();
        for (int i = 0; i < keys.length ; i++){
            for (DtoJugador dtoJugador: obtenerJugadores(posiciones[i], keys[i])) {
                equipoA.add(dtoJugador);
            }
        }
        return equipoA;
    }

    private List<DtoJugador> obtenerJugadores(String posicion, Long cantidad){
        List<DtoJugador> jugadores = this.daoJugador.listarPorPosicion(posicion);
        List<Integer> registroObtenido = new ArrayList<>();
        List<DtoJugador> resultado = new ArrayList<>();
        for (int i = 0; i < cantidad; i++){
            int random = numeroAleatorioEnRango(0, cantidadDeLista(posicion));
            if (!registroObtenido.contains(random)){
                registroObtenido.add(random);
                resultado.add(jugadores.get(random));
            }
            else {
                cantidad++;
            }
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
