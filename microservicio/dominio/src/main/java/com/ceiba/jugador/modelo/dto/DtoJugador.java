package com.ceiba.jugador.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoJugador {
    private Long id;
    private Long documento;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private float peso;
    private float altura;
    private String posicion;
    private String pieHabil;

}
