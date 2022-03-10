package com.ceiba.asistencia.comando;

import com.ceiba.jugador.modelo.entidad.Jugador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAsistencia {

    private Long id;
    private LocalDate fecha;
    private Jugador jugador;
}
