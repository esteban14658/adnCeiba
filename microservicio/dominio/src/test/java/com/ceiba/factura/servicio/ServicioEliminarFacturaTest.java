package com.ceiba.factura.servicio;

import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.asistencia.servicio.ServicioCrearAsistencia;
import com.ceiba.asistencia.servicio.testdatabuilder.AsistenciaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

public class ServicioEliminarFacturaTest {

    @Test
    @DisplayName("Deberia eliminar la factura llamando al repositorio")
    void deberiaEliminarLaFacturaLlamandoAlRepositorio() {

        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        ServicioEliminarFactura servicioEliminarFactura = new ServicioEliminarFactura(repositorioFactura);
        servicioEliminarFactura.ejecutar(1L);
        Mockito.verify(repositorioFactura, Mockito.times(1)).eliminar(1l);

    }
}
