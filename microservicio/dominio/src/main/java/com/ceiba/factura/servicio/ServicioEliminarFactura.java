package com.ceiba.factura.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;

public class ServicioEliminarFactura {

    public static final String LA_FACTURA_NO_EXISTE_EN_EL_SISTEMA = "La factura no existe en el sistema";
    private final RepositorioFactura repositorioFactura;

    public ServicioEliminarFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioFactura.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id){
        boolean existe = this.repositorioFactura.existePorId(id);
        if (!existe) {
            throw new ExcepcionSinDatos(LA_FACTURA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
