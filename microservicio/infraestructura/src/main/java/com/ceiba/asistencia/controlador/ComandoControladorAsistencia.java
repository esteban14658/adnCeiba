package com.ceiba.asistencia.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.comando.manejador.ManejadorCrearAsistencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencias")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Api(tags = { "Controlador comando asistencia"})
public class ComandoControladorAsistencia {

    public final ManejadorCrearAsistencia manejadorCrearAsistencia;

    public ComandoControladorAsistencia(ManejadorCrearAsistencia manejadorCrearAsistencia) {
        this.manejadorCrearAsistencia = manejadorCrearAsistencia;
    }

    @PostMapping
    @ApiOperation("Crear asistencia")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAsistencia comandoAsistencia) {
        return manejadorCrearAsistencia.ejecutar(comandoAsistencia);
    }
}
