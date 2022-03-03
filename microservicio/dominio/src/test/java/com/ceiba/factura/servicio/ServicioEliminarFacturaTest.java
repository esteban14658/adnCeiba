package com.ceiba.factura.servicio;

import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarFacturaTest {

    @Test
    @DisplayName("Deberia eliminar el jugador llamando al repositorio")
    void deberiaEliminarElJugadorLlamandoAlRepositorio() {
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        ServicioEliminarFactura servicioEliminarFactura = new ServicioEliminarFactura(repositorioFactura);

        servicioEliminarFactura.ejecutar(1L);

        Mockito.verify(repositorioFactura, Mockito.times(1)).eliminar(1l);

    }
}
