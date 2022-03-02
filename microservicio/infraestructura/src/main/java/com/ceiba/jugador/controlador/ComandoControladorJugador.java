package com.ceiba.jugador.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.jugador.comando.ComandoJugador;
import com.ceiba.jugador.comando.manejador.ManejadorActualizarJugador;
import com.ceiba.jugador.comando.manejador.ManejadorCrearJugador;
import com.ceiba.jugador.comando.manejador.ManejadorEliminarJugador;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jugadores")
@Api(tags = { "Controlador comando jugador"})
public class ComandoControladorJugador {

    private final ManejadorCrearJugador manejadorCrearJugador;
	private final ManejadorEliminarJugador manejadorEliminarJugador;
	private final ManejadorActualizarJugador manejadorActualizarJugador;

    @Autowired
    public ComandoControladorJugador(ManejadorCrearJugador manejadorCrearJugador,
									 ManejadorEliminarJugador manejadorEliminarJugador,
									 ManejadorActualizarJugador manejadorActualizarJugador) {
        this.manejadorCrearJugador = manejadorCrearJugador;
		this.manejadorEliminarJugador = manejadorEliminarJugador;
		this.manejadorActualizarJugador = manejadorActualizarJugador;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoJugador comandoJugador) {
        return manejadorCrearJugador.ejecutar(comandoJugador);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Usuario")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarJugador.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Usuario")
	public void actualizar(@RequestBody ComandoJugador comandoJugador,@PathVariable Long id) {
		comandoJugador.setId(id);
		manejadorActualizarJugador.ejecutar(comandoJugador);
	}
}
