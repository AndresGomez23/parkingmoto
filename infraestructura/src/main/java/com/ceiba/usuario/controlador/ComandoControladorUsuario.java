/**package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearMoto;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorUsuario {

    private final ManejadorCrearMoto manejadorCrearMoto;
	private final ManejadorEliminarUsuario manejadorEliminarUsuario;
	private final ManejadorActualizarUsuario manejadorActualizarUsuario;

    @Autowired
    public ComandoControladorUsuario(ManejadorCrearMoto manejadorCrearMoto,
                                     ManejadorEliminarUsuario manejadorEliminarUsuario,
                                     ManejadorActualizarUsuario manejadorActualizarUsuario) {
		this.manejadorCrearMoto = manejadorCrearMoto;
		this.manejadorEliminarUsuario = manejadorEliminarUsuario;
		this.manejadorActualizarUsuario = manejadorActualizarUsuario;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoUsuario comandoUsuario) {
        return manejadorCrearMoto.ejecutar(comandoUsuario);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Usuario")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarUsuario.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Usuario")
	public void actualizar(@RequestBody ComandoUsuario comandoUsuario,@PathVariable Long id) {
		comandoUsuario.setId(id);
		manejadorActualizarUsuario.ejecutar(comandoUsuario);
	}
}
**/