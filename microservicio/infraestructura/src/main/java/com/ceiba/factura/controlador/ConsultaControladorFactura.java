package com.ceiba.factura.controlador;

import com.ceiba.factura.consulta.ManejadorListarFacturas;
import com.ceiba.factura.consulta.ManejadorListarJugadoresSinFactura;
import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@Api(tags={"Controlador consulta factura"})
public class ConsultaControladorFactura {

    private final ManejadorListarFacturas manejadorListarFacturas;
    private final ManejadorListarJugadoresSinFactura manejadorListarJugadoresSinFactura;

    public ConsultaControladorFactura(ManejadorListarFacturas manejadorListarFacturas, ManejadorListarJugadoresSinFactura manejadorListarJugadoresSinFactura) {
        this.manejadorListarFacturas = manejadorListarFacturas;
        this.manejadorListarJugadoresSinFactura = manejadorListarJugadoresSinFactura;
    }

    @GetMapping
    @ApiOperation("Listar facturas activas")
    public List<DtoFactura> listar() {
        return this.manejadorListarFacturas.ejecutar();
    }

    @GetMapping(value = "/factura")
    @ApiOperation("Listar jugadores sin factura activa")
    public List<DtoJugador> listarJugadorSinFactura(){
        return this.manejadorListarJugadoresSinFactura.ejecutar();
    }
}
