package com.ceiba.factura.comando;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFactura {

    private Long id;
    private Long valor;
    private LocalDate fechaIngreso;
    private LocalDate fechaCaducidad;
    private DtoJugador jugador;
    private Integer estado;
    private String descripcion;

}
