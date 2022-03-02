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
        Long sumatoria = 1L + defensas + mediocampistas + delanteros;
        if (sumatoria > 11L){
            throw new ExcepcionLongitudValor("No puede sobrepasar la cantidad permitida de jugadores");
        }
        List<DtoJugador> equipoA = new ArrayList<>();
        int contador = 0;
        for (DtoJugador item: obtenerJugadores("Portero",1L)) {
            if (contador < 1) {
                equipoA.add(item);
            }
            contador++;
        };
        contador = 0;
        for (DtoJugador item: obtenerJugadores("Defensa", defensas)) {
            if (contador < defensas) {
                equipoA.add(item);
            }
            contador++;
        };
        contador = 0;
        for (DtoJugador item: obtenerJugadores("Mediocampista", mediocampistas)) {
            if (contador < mediocampistas) {
                equipoA.add(item);
            }
            contador++;
        };
        contador = 0;
        for (DtoJugador item: obtenerJugadores("Delantero", delanteros)) {
            if (contador < delanteros) {
                equipoA.add(item);
            }
            contador++;
        };
        return equipoA;
    }

    private List<DtoJugador> obtenerJugadores(String posicion, Long cantidad){
        List<DtoJugador> jugadores = this.daoJugador.listarPorPosicion(posicion);
        List<DtoJugador> resultado = new ArrayList<>();
        for (DtoJugador item: jugadores) {
            if (posicion.equals("Portero") && resultado.size() < cantidad){
                int random = numeroAleatorioEnRango(0, jugadores.size());
                item = jugadores.get(random);
                resultado.add(item);
                System.out.println("Random = " + random);
            }
            else if (posicion.equals("Defensa") && resultado.size() < cantidad){
                int random = numeroAleatorioEnRango(0, jugadores.size());
                item = jugadores.get(random);
                resultado.add(item);
            }
            else if (posicion.equals("Mediocampista") && resultado.size() < cantidad){
                int random = numeroAleatorioEnRango(0, jugadores.size());
                item = jugadores.get(random);
                resultado.add(item);
            }
            else if (posicion.equals("Delantero") && resultado.size() < cantidad){
                int random = numeroAleatorioEnRango(0, jugadores.size());
                item = jugadores.get(random);
                resultado.add(item);
            }
            else {
                //throw new ExcepcionValorInvalido("No se reconoce la posicion ingresada");
            }
        };
        return resultado;
    }

    private static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo);
    }
}
