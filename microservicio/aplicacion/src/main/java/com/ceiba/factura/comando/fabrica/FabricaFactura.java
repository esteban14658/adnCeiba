package com.ceiba.factura.comando.fabrica;

import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import org.springframework.stereotype.Component;

@Component
public class FabricaFactura {

    public Factura crear(ComandoFactura comandoFactura){
        return new Factura(
              comandoFactura.getId(),
              comandoFactura.getValor(),
              comandoFactura.getFechaIngreso(),
              comandoFactura.getFechaCaducidad(),
              comandoFactura.getJugador(),
              comandoFactura.getEstado(),
              comandoFactura.getDescripcion()
        );
    }
}
