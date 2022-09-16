package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCarro;
import com.ceiba.usuario.comando.manejador.ManejadorCrearCarro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creacion-carro")
@Api(tags = {"Controlador creacion carro"})
public class CrearCarroControlador {
    private final ManejadorCrearCarro manejadorCrearCarro;

    public CrearCarroControlador(ManejadorCrearCarro manejadorCrearCarro){
        this.manejadorCrearCarro = manejadorCrearCarro;
    }

    @PostMapping(value ="/crear")
    @ApiOperation("Crear carro")
    public ComandoRespuesta<String> crearCarro(@RequestBody ComandoCarro comandoCarro) {
        return this.manejadorCrearCarro.ejecutar(comandoCarro);
    }
}
