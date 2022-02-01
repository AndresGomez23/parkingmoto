package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoMoto;
import com.ceiba.usuario.comando.manejador.ManejadorCrearMoto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creacion")
@Api(tags = {"Controlador creacion moto"})
public class CrearMotoControlador {

    private final ManejadorCrearMoto manejadorCrearMoto;

    public CrearMotoControlador(ManejadorCrearMoto manejadorCrearMoto){
        this.manejadorCrearMoto = manejadorCrearMoto;
    }

    @PostMapping(value ="/crear")
    @ApiOperation("Crear motos")
    public ComandoRespuesta<String> crear(@RequestBody ComandoMoto comandoMoto) {
        return this.manejadorCrearMoto.ejecutar(comandoMoto);
    }
}
