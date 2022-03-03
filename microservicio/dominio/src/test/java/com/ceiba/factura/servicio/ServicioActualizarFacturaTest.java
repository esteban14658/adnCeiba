package com.ceiba.factura.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import com.ceiba.jugador.servicio.ServicioActualizarJugador;
import com.ceiba.jugador.servicio.testdatabuilder.JugadorTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarFacturaTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del jugador")
    void deberiaValidarLaExistenciaPreviaDelJugador() {
        // arrange
        Factura factura = new FacturaTestDataBuilder().conId(1L).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarFactura servicioActualizarFactura = new ServicioActualizarFactura(repositorioFactura);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarFactura.ejecutar(factura), ExcepcionSinDatos.class,"La factura no esta registrada en el sistema");
    }

}
