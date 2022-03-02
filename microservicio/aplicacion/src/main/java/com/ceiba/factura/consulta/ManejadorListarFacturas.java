package com.ceiba.factura.consulta;

import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.factura.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarFacturas {

    private final DaoFactura daoFactura;

    public ManejadorListarFacturas(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public List<DtoFactura> ejecutar() { return this.daoFactura.listar(); }
}
