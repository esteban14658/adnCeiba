package com.ceiba.factura.modelo.entidad;

import com.ceiba.jugador.modelo.entidad.Jugador;
import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Factura {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO = "Se debe ingresar la fecha de ingreso";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_CADUCIDAD = "Se debe ingresar la fecha de caducidad";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_LA_FACTURA = "Se debe ingresar el valor de la factura";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_JUGADOR = "Se debe ingresar el id del jugador";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO_DE_LA_SUSCRIPCION = "Se debe ingresar el estado de la suscripcion";
    private static final String SE_DEBE_INGRESAR_UNA_DESCRIPCION = "Se debe ingresar una descripcion";

    private Long id;
    private Long valor;
    private LocalDate fechaIngreso;
    private LocalDate fechaCaducidad;
    private Jugador jugador;
    private Integer estado;
    private String descripcion;

    public Factura(Long id, Long valor, LocalDate fechaIngreso, LocalDate fechaCaducidad, Jugador jugador,
                   Integer estado, String descripcion) {

        validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR_DE_LA_FACTURA);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO);
        validarObligatorio(fechaCaducidad, SE_DEBE_INGRESAR_LA_FECHA_DE_CADUCIDAD);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO_DE_LA_SUSCRIPCION);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_UNA_DESCRIPCION);

        this.id = id;
        this.valor = valor;
        this.fechaIngreso = fechaIngreso;
        this.fechaCaducidad = fechaCaducidad;
        this.jugador = jugador;
        this.estado = estado;
        this.descripcion = descripcion;
    }
}
