package com.ceiba.jugador.modelo.entidad;


import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Jugador {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_JUGADOR = "Se debe ingresar el nombre del jugador";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_JUGADOR = "Se debe ingresar el apellido del jugador";
    private static final String SE_DEBE_INGRESAR_EL_DOCUMENTO_DEL_JUGADOR = "Se debe ingresar el documento del jugador";
    private static final String SE_DEBE_INGRESAR_LA_POSICION_DEL_JUGADOR = "Se debe ingresar la posicion del jugador";
    private static final String SE_DEBE_INGRESAR_EL_PIE_HABIL_DEL_JUGADOR = "Se debe ingresar el pied habil del jugador";

    private Long id;
    private Long documento;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private float peso;
    private float altura;
    private String posicion;
    private String pieHabil;

    public Jugador(Long id, Long documento, String nombre, String apellido, LocalDate fechaNacimiento,
                   float peso, float altura, String posicion, String pieHabil) {
        validarObligatorio(documento, SE_DEBE_INGRESAR_EL_DOCUMENTO_DEL_JUGADOR);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_JUGADOR);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO_DEL_JUGADOR);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);
        validarObligatorio(posicion, SE_DEBE_INGRESAR_LA_POSICION_DEL_JUGADOR);
        validarObligatorio(pieHabil, SE_DEBE_INGRESAR_EL_PIE_HABIL_DEL_JUGADOR);


        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.posicion = posicion;
        this.pieHabil = pieHabil;
    }

}
