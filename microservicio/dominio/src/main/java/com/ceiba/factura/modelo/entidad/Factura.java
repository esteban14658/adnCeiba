package com.ceiba.factura.modelo.entidad;

import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Factura {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO = "Se debe ingresar la fecha de ingreso";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_CADUCIDAD = "Se debe ingresar la fecha de caducidad";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_LA_FACTURA = "Se debe ingresar el valor de la factura";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_JUGADOR = "Se debe ingresar el id del jugador";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO_DE_LA_SUSCRIPCION = "Se debe ingresar el estado de la suscripcion";
    private static final String SE_DEBE_INGRESAR_UNA_DESCRIPCION = "Se debe ingresar una descripcion";
    public static final long VALOR_MENSUAL = 100000L;
    public static final long TRES_MESES = 3L;
    public static final double MENOS_QUINCE_PORCIENTO = 0.85;
    public static final int SEIS_MESES = 6;
    public static final double MENOS_TREINTA_PORCIENTO = 0.7;

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

    public double mensualidadNormal() { return VALOR_MENSUAL; }

    public double promocionTresMeses(){
        return VALOR_MENSUAL * TRES_MESES * MENOS_QUINCE_PORCIENTO;
    }

    public double promocionSeisMeses(){
        return VALOR_MENSUAL * SEIS_MESES * MENOS_TREINTA_PORCIENTO;
    }

    public String sumarMeses(String fecha, Long meses) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
        fechaLocal = fechaLocal.plusMonths(meses);
        return fechaLocal.format(formateador);
    }
}
