package com.ceiba.factura.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.comando.manejador.ManejadorCrearFactura;
import com.ceiba.factura.comando.manejador.ManejadorEliminarFactura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturas")
@Api(tags = { "Controlador comando factura"})
public class ComandoControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;
    private final ManejadorEliminarFactura manejadorEliminarFactura;

    @Autowired
    public ComandoControladorFactura(ManejadorCrearFactura manejadorCrearFactura, ManejadorEliminarFactura manejadorEliminarFactura) {
        this.manejadorCrearFactura = manejadorCrearFactura;
        this.manejadorEliminarFactura = manejadorEliminarFactura;
    }

    @PostMapping
    @ApiOperation("Crear factura")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoFactura comandoFactura) {
        return manejadorCrearFactura.ejecutar(comandoFactura);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar una factura")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarFactura.ejecutar(id);
    }
}
