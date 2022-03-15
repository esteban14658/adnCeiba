package com.ceiba.asistencia.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.comando.manejador.ManejadorCrearAsistencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencias")
@Api(tags = { "Controlador comando asistencia"})
public class ComandoControladorAsistencia {

    public final ManejadorCrearAsistencia manejadorCrearAsistencia;

    @Autowired
    public ComandoControladorAsistencia(ManejadorCrearAsistencia manejadorCrearAsistencia) {
        this.manejadorCrearAsistencia = manejadorCrearAsistencia;
    }

    @PostMapping
    @ApiOperation("Crear asistencia")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAsistencia comandoAsistencia) {
        return manejadorCrearAsistencia.ejecutar(comandoAsistencia);
    }
}
