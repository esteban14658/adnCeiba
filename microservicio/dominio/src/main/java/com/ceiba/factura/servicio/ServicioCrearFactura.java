package com.ceiba.factura.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;

import java.time.LocalDate;

public class ServicioCrearFactura {

    public static final String EL_JUGADOR_AL_QUE_DESEA_ASIGNARLE_LA_FACTURA_NO_ESTA_REGISTRADO = "El jugador al que desea asignarle la factura no esta registrado";
    public static final String YA_TIENE_UNA_FACTURA_ASIGNADA = "Ya tiene una factura asignada";

    private final RepositorioFactura repositorioFactura;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public Long ejecutar(Factura factura, Long meses) {
        validarExistenciaPrevia(factura);
        factura = ingresoDeDatos(factura, meses);
        return this.repositorioFactura.crear(factura);
    }

    public Factura ingresoDeDatos(Factura factura, Long meses) {
        String fechaInicio = String.valueOf(LocalDate.now());
        String fechaCaducidad = factura.sumarMeses(fechaInicio, meses);
        double valorFactura = 0;
        if (meses == 1){
            valorFactura = factura.mensualidadNormal();
        } else if (meses == 3){
            valorFactura = factura.promocionTresMeses();
        } else if (meses == 6){
            valorFactura = factura.promocionSeisMeses();
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
