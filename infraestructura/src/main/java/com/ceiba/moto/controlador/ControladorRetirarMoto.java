package com.ceiba.moto.controlador;

import com.ceiba.moto.comando.manejador.ManejadorRetirarMoto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/retirar")
@Api(tags = {"Controlador retirar moto"})
public class ControladorRetirarMoto {

    private final ManejadorRetirarMoto manejadorRetirarMoto;

    public ControladorRetirarMoto(ManejadorRetirarMoto manejadorRetirarMoto) {
        this.manejadorRetirarMoto = manejadorRetirarMoto;
    }

    @DeleteMapping(value = "/{placa}")
    @ApiOperation("Rerirar moto")
    public void retirar(@PathVariable String placa ){
        this.manejadorRetirarMoto.ejecutar(placa);
    }
}