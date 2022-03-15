package com.ceiba.factura.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;

import java.time.LocalDate;

public class ServicioCrearFactura {

    public static final String YA_TIENE_UNA_FACTURA_ASIGNADA = "Ya tiene una factura asignada";
    public static final String SOLO_SE_PUEE_INGRESAR_VALORES_DE_1_3_Y_6_MESES = "Solo se puee ingresar valores de 1, 3 y 6 meses";
    public static final int UN_MES = 1;
    public static final int TRIMESTRAL = 3;
    public static final int SEMESTRAL = 6;

    private final RepositorioFactura repositorioFactura;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public Long ejecutar(Factura factura, Long meses) {
        validarExistenciaPrevia(factura);
        factura = ingresoDeDatos(factura, meses);
        return this.repositorioFactura.crear(factura);
    }

    private Factura ingresoDeDatos(Factura factura, Long meses) {
        String fechaInicio = String.valueOf(LocalDate.now());
        String fechaCaducidad = factura.sumarMeses(fechaInicio, meses);
        double valorFactura = 0;
        if (meses == UN_MES){
            valorFactura = factura.mensualidadNormal();
        } else if (meses == TRIMESTRAL){
            valorFactura = factura.promocionTresMeses();
        } else if (meses == SEMESTRAL){
            valorFactura = factura.promocionSeisMeses();
        } else {
            throw new ExcepcionValorInvalido(SOLO_SE_PUEE_INGRESAR_VALORES_DE_1_3_Y_6_MESES);
        }
        Long valor = Math.round(valorFactura);
        return new Factura(factura.getId(), valor, LocalDate.parse(fechaInicio),
                LocalDate.parse(fechaCaducidad), factura.getJugador(), factura.getEstado(), factura.getDescripcion());
    }

    private void validarExistenciaPrevia(Factura factura) {
        boolean existe = this.repositorioFactura.existePorIdJugador(factura.getJugador().getId());
        if(existe) {
            throw new ExcepcionSinDatos(YA_TIENE_UNA_FACTURA_ASIGNADA);
        }
    }
}
