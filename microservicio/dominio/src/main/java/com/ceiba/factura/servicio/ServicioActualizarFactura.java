package com.ceiba.factura.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.jugador.modelo.entidad.Jugador;

public class ServicioActualizarFactura {
    public static final String LA_FACTURA_NO_ESTA_REGISTRADA_EN_EL_SISTEMA = "La factura no esta registrada en el sistema";
    private final RepositorioFactura repositorioFactura;

    public ServicioActualizarFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura){
        validarExistenciaPrevia(factura);
        this.repositorioFactura.actualizar(factura);
    }


    private void validarExistenciaPrevia(Factura factura){
        boolean existe = this.repositorioFactura.existePorId(factura.getId());
        if(!existe) {
            throw new ExcepcionSinDatos(LA_FACTURA_NO_ESTA_REGISTRADA_EN_EL_SISTEMA);
        }
    }
}
