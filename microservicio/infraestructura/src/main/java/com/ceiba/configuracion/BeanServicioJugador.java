package com.ceiba.configuracion;

import com.ceiba.jugador.puerto.dao.DaoJugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import com.ceiba.jugador.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioJugador {

    @Bean
    public ServicioCrearJugador servicioCrearJugador(RepositorioJugador repositorioJugador) {
        return new ServicioCrearJugador(repositorioJugador);
    }

    @Bean
    public ServicioEliminarJugador servicioEliminarJugador(RepositorioJugador repositorioJugador) {
        return new ServicioEliminarJugador(repositorioJugador);
    }

    @Bean
    public ServicioActualizarJugador servicioActualizarJugador(RepositorioJugador repositorioJugador) {
        return new ServicioActualizarJugador(repositorioJugador);
    }

    @Bean
    public ServicioObtenerPorIdJugador servicioObtenerPorIdJugador(DaoJugador daoJugador, RepositorioJugador repositorioJugador) {
        return new ServicioObtenerPorIdJugador(daoJugador, repositorioJugador);
    }

    @Bean
    public ServicioObtenerEquipo servicioObtenerEquipo(DaoJugador daoJugador, RepositorioJugador repositorioJugador){
        return new ServicioObtenerEquipo(daoJugador, repositorioJugador);
    }

}
