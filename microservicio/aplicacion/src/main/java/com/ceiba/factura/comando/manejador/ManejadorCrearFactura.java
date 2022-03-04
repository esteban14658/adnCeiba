package com.ceiba.factura.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.comando.fabrica.FabricaFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.servicio.ServicioCrearFactura;
import com.ceiba.jugador.comando.ComandoJugador;
import com.ceiba.jugador.comando.fabrica.FabricaJugador;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.servicio.ServicioCrearJugador;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFactura implements ManejadorComandoRespuesta<ComandoFactura, ComandoRespuesta<Long>> {

    private final FabricaFactura fabricaFactura;
    private final ServicioCrearFactura servicioCrearFactura;

    public ManejadorCrearFactura(FabricaFactura fabricaFactura, ServicioCrearFactura servicioCrearFactura) {
        this.fabricaFactura = fabricaFactura;
        this.servicioCrearFactura = servicioCrearFactura;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoFactura comandoFactura) {
        Factura factura = this.fabricaFactura.crear(comandoFactura);
        return new ComandoRespuesta<>(this.servicioCrearFactura.ejecutar(factura, comandoFactura.getMeses()));
    }
}
