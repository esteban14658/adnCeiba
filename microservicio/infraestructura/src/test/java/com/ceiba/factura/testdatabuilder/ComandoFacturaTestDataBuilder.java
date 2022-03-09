package com.ceiba.factura.testdatabuilder;

import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.jugador.comando.ComandoJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.testdatabuilder.ComandoJugadorTestDataBuilder;

import java.time.LocalDate;

public class ComandoFacturaTestDataBuilder {

    private Long id;
    private Long valor;
    private LocalDate fechaIngreso;
    private LocalDate fechaCaducidad;
    private Jugador jugador;
    private Integer estado;
    private String descripcion;
    private Long meses;

    public ComandoFacturaTestDataBuilder() {
        valor = Long.valueOf(100000);
        fechaIngreso = LocalDate.parse("2022-03-09");
        fechaCaducidad = LocalDate.parse("2022-06-09");
        jugador = new Jugador(2L,89808080L, "Juanito", "Perez", LocalDate.now(),
                (float) 45.6, (float) 1.65, "Portero", "Derecho");
        estado = 1;
        descripcion = "Tres meses";
        meses = 3L;
    }

    public ComandoFactura build() {
        return new ComandoFactura(id, valor, fechaIngreso, fechaCaducidad, jugador, estado, descripcion, meses);
    }
}
