package com.ceiba.asistencia.modelo.dto;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoAsistencia {

    private Long id;
    private LocalDate fecha;
    private DtoJugador jugador;

}
