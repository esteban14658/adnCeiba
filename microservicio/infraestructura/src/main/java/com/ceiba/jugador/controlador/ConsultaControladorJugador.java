package com.ceiba.jugador.controlador;

import com.ceiba.jugador.consulta.*;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
@Api(tags={"Controlador consulta jugador"})
public class ConsultaControladorJugador {

    private final ManejadorListarJugadores manejadorListarJugadores;
    private final ManejadorObtenerPorIdJugador manejadorObtenerPorIdJugador;
    private final ManejadorListarJugadoresPorPosicion manejadorListarJugadoresPorPosicion;
    private final ManejadorListarJugadoresPorPieHabil manejadorListarJugadoresPorPieHabil;
    private final ManejadorObtenerEquipoJugadores manejadorObtenerEquipoJugadores;

    public ConsultaControladorJugador(ManejadorListarJugadores manejadorListarJugadores,
                                      ManejadorObtenerPorIdJugador manejadorObtenerPorIdJugador,
                                      ManejadorListarJugadoresPorPosicion manejadorListarJugadoresPorPosicion,
                                      ManejadorListarJugadoresPorPieHabil manejadorListarJugadoresPorPieHabil,
                                      ManejadorObtenerEquipoJugadores manejadorObtenerEquipoJugadores) {
        this.manejadorListarJugadores = manejadorListarJugadores;
        this.manejadorObtenerPorIdJugador = manejadorObtenerPorIdJugador;
        this.manejadorListarJugadoresPorPosicion = manejadorListarJugadoresPorPosicion;
        this.manejadorListarJugadoresPorPieHabil = manejadorListarJugadoresPorPieHabil;
        this.manejadorObtenerEquipoJugadores = manejadorObtenerEquipoJugadores;
    }

    @GetMapping
    @ApiOperation("Listar jugadores")
    public List<DtoJugador> listar() {
        return this.manejadorListarJugadores.ejecutar();
    }

    @GetMapping(value = "listarPorPosicion/{posicion}")
    @ApiOperation("Listar jugadores por posicion")
    public List<DtoJugador> listarPorPosicion(@PathVariable String posicion) {
        return this.manejadorListarJugadoresPorPosicion.ejecutar(posicion);
    }

    @GetMapping(value = "listarPorPieHabil/{pieHabil}")
    @ApiOperation("Listar jugadores por pie habil")
    public List<DtoJugador> listarPorPieHabil(@PathVariable String pieHabil) {
        return this.manejadorListarJugadoresPorPieHabil.ejecutar(pieHabil);
    }

    @GetMapping(value = "obtenerEquipo/{defensas}/{mediocampistas}/{delanteros}")
    @ApiOperation("obtener equipo")
    public List<DtoJugador> obtenerEquipo(@PathVariable Long defensas, @PathVariable Long mediocampistas,
                                          @PathVariable Long delanteros) {
        return this.manejadorObtenerEquipoJugadores.ejecutar(defensas, mediocampistas, delanteros);
    }

    @GetMapping(value = "obtenerPorId/{id}")
    @ApiOperation("obtener jugador por id")
    public DtoJugador obtenerPorId(@PathVariable Long id) {
        return this.manejadorObtenerPorIdJugador.ejecutar(id);
    }

}
