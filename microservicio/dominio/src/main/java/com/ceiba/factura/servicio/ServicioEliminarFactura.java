package com.ceiba.factura.servicio;

import com.ceiba.factura.puerto.repositorio.RepositorioFactura;

public class ServicioEliminarFactura {

    private final RepositorioFactura repositorioFactura;

    public ServicioEliminarFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Long id) {
        this.repositorioFactura.eliminar(id);
    }
}
