package com.ceiba.usuario.controlador;

import com.ceiba.usuario.comando.manejador.ManejadorEliminarMoto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/eliminar")
@Api(tags = {"Controlador eliminar moto"})
public class EliminarMotoControlador {

    private final ManejadorEliminarMoto manejadorEliminarMoto;

    public EliminarMotoControlador(ManejadorEliminarMoto manejadorEliminarMoto) {
        this.manejadorEliminarMoto = manejadorEliminarMoto;
    }

    @DeleteMapping(value = "/{placa}")
    @ApiOperation("Eliminar moto")
    public void eliminar(@PathVariable String placa ){
        this.manejadorEliminarMoto.ejecutar(placa);
    }
}