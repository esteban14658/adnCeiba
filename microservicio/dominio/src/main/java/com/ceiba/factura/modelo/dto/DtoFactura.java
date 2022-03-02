package com.ceiba.factura.modelo.dto;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoFactura {

    private Long id;
    private Integer valor;
    private LocalDate fechaIngreso;
    private LocalDate fechaCaducidad;
    private DtoJugador jugador;
    private Integer estado;
    private String descripcion;

}
