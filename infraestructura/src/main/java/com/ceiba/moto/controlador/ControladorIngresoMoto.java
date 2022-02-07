package com.ceiba.moto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.comando.manejador.ManejadorIngresarMoto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingreso")
@Api(tags = {"Controlador ingreso de la  moto"})
public class ControladorIngresoMoto {

    private final ManejadorIngresarMoto manejadorIngresarMoto;

    public ControladorIngresoMoto(ManejadorIngresarMoto manejadorIngresarMoto){
        this.manejadorIngresarMoto = manejadorIngresarMoto;
    }

    @PostMapping(value ="/moto")
    @ApiOperation("ingreso de la moto")
    public ComandoRespuesta<String> ingresar(@RequestBody ComandoMoto comandoMoto) {
        return this.manejadorIngresarMoto.ejecutar(comandoMoto);
    }
}
