package com.ceiba.factura.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.comando.manejador.ManejadorCrearFactura;
import com.ceiba.jugador.comando.ComandoJugador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facturas")
@Api(tags = { "Controlador comando factura"})
public class ComandoControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;

    @Autowired
    public ComandoControladorFactura(ManejadorCrearFactura manejadorCrearFactura) {
        this.manejadorCrearFactura = manejadorCrearFactura;
    }

    @PostMapping
    @ApiOperation("Crear factura")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoFactura comandoFactura) {
        return manejadorCrearFactura.ejecutar(comandoFactura);
    }
}
