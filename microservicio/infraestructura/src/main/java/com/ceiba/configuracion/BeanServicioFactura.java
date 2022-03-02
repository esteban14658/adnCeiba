package com.ceiba.configuracion;

import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioCrearFactura;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioFactura {

    @Bean
    public ServicioCrearFactura servicioCrearFactura(RepositorioFactura repositorioFactura) {
        return new ServicioCrearFactura(repositorioFactura);
    }

}
