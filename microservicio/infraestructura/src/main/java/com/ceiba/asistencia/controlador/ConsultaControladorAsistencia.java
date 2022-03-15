package com.ceiba.asistencia.controlador;

import com.ceiba.asistencia.consulta.ManejadorListarAsistencias;
import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asistencias")
@Api(tags={"Controlador consulta asistencia"})
public class ConsultaControladorAsistencia {

    private final ManejadorListarAsistencias manejadorListarAsistencias;

    public ConsultaControladorAsistencia(ManejadorListarAsistencias manejadorListarAsistencias) {
        this.manejadorListarAsistencias = manejadorListarAsistencias;
    }

    @GetMapping
    @ApiOperation("Listar asistencias")
    public List<DtoAsistencia> listar() {
        return this.manejadorListarAsistencias.ejecutar();
    }
}
