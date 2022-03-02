package com.ceiba.factura.entidad;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.servicio.testdatabuilder.FacturaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacturaTest {

    @Test
    @DisplayName("Deberia crear correctamente la factura")
    void DeberiaCrearCorrectamenteLaFactura(){
        // Arrange
        LocalDate date = LocalDate.now();
        // act
        Factura factura = new FacturaTestDataBuilder().conId(1L).build();
        // assert
        assertEquals(1L, factura.getId());
        assertEquals(420000L, factura.getValor());
        assertEquals(LocalDate.parse("2022-01-10"), factura.getFechaIngreso());
        assertEquals(LocalDate.parse("2022-04-09"), factura.getFechaCaducidad());
        assertEquals(10101010L, factura.getJugador().getDocumento());
        assertEquals(1, factura.getEstado());
        assertEquals("tres meses", factura.getDescripcion());
    }

}
