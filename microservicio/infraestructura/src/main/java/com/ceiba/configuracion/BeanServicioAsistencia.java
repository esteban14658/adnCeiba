package com.ceiba.configuracion;

import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.asistencia.servicio.ServicioCrearAsistencia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioAsistencia {

    @Bean
    public ServicioCrearAsistencia servicioCrearAsistencia(RepositorioAsistencia repositorioAsistencia){
        return new ServicioCrearAsistencia(repositorioAsistencia);
    }
}
