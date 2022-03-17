package com.ceiba.jugador.controlador;

import com.ceiba.jugador.consulta.*;
import com.ceiba.jugador.modelo.dto.DtoFiltro;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
@Api(tags={"Controlador consulta jugador"})
public class ConsultaControladorJugador {

    private final ManejadorListarJugadores manejadorListarJugadores;
    private final ManejadorObtenerPorDocumentoJugador manejadorObtenerPorDocumentoJugador;
    private final ManejadorObtenerEquipoJugadores manejadorObtenerEquipoJugadores;
    private final ManejadorListarJugadoresSinAsistencia manejadorListarJugadoresSinAsistencia;
    private final ManejadorListarJugadoresPorCategoria manejadorListarJugadoresPorCategoria;

    public ConsultaControladorJugador(ManejadorListarJugadores manejadorListarJugadores,
                                      ManejadorObtenerPorDocumentoJugador manejadorObtenerPorDocumentoJugador,
                                      ManejadorObtenerEquipoJugadores manejadorObtenerEquipoJugadores,
                                      ManejadorListarJugadoresSinAsistencia manejadorListarJugadoresSinAsistencia,
                                      ManejadorListarJugadoresPorCategoria manejadorListarJugadoresPorCategoria) {
        this.manejadorListarJugadores = manejadorListarJugadores;
        this.manejadorObtenerPorDocumentoJugador = manejadorObtenerPorDocumentoJugador;
        this.manejadorObtenerEquipoJugadores = manejadorObtenerEquipoJugadores;
        this.manejadorListarJugadoresSinAsistencia = manejadorListarJugadoresSinAsistencia;
        this.manejadorListarJugadoresPorCategoria = manejadorListarJugadoresPorCategoria;
    }


    @GetMapping
    @ApiOperation("Listar todos los jugadores")
    public List<DtoJugador> listar() {
        return this.manejadorListarJugadores.ejecutar();
    }

    @GetMapping(value = "/asistencia")
    @ApiOperation("Listar jugadores sin asistencia de hoy")
    public List<DtoJugador> listarJugadoresSinAsistencia(){
        return this.manejadorListarJugadoresSinAsistencia.ejecutar();
    }

    @GetMapping(value = "/categoria/{fecha}")
    @ApiOperation("Listar jugadores por categoria")
    public List<DtoJugador> listarPorCategoria(@PathVariable String fecha) {
        return this.manejadorListarJugadoresPorCategoria.ejecutar(fecha);
    }

    @GetMapping(value = "/equipo")
    @ApiOperation("obtener equipo")
    public List<DtoJugador> obtenerEquipo(@RequestParam(value = "defensas") String defensas,
                                          @RequestParam(value = "mediocampistas") String mediocampistas,
                                          @RequestParam(value = "delanteros") String delanteros,
                                          DtoFiltro dtoFiltro) {
        dtoFiltro.setDefensas(defensas);
        dtoFiltro.setMediocampistas(mediocampistas);
        dtoFiltro.setDelanteros(delanteros);
        return this.manejadorObtenerEquipoJugadores.ejecutar(dtoFiltro);
    }

    @GetMapping(value = "/jugador/{documento}")
    @ApiOperation("obtener jugador por documento")
    public DtoJugador obtenerPorDocumento(@PathVariable Long documento) {
        return this.manejadorObtenerPorDocumentoJugador.ejecutar(documento);
    }

}
