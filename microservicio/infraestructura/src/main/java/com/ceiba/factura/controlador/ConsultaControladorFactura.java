package com.ceiba.factura.controlador;

import com.ceiba.factura.consulta.ManejadorListarFacturas;
import com.ceiba.factura.modelo.dto.DtoFactura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@Api(tags={"Controlador consulta factura"})
public class ConsultaControladorFactura {

    private final ManejadorListarFacturas manejadorListarFacturas;

    public ConsultaControladorFactura(ManejadorListarFacturas manejadorListarFacturas) {
        this.manejadorListarFacturas = manejadorListarFacturas;
    }

    @GetMapping
    @ApiOperation("Listar facturas activas")
    public List<DtoFactura> listar() {
        return this.manejadorListarFacturas.ejecutar();
    }
}
