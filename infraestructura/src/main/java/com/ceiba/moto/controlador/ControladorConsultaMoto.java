package com.ceiba.moto.controlador;

import java.util.List;

import com.ceiba.moto.consulta.ManejadorListarMoto;
import com.ceiba.moto.modelo.dto.DtoMoto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/moto")
@Api(tags={"Controlador consulta motos"})
public class ControladorConsultaMoto {

    private final ManejadorListarMoto manejadorListarMoto;

    public ControladorConsultaMoto(ManejadorListarMoto manejadorListarMoto) {
        this.manejadorListarMoto = manejadorListarMoto;
    }

    @GetMapping(value = "/all")
    @ApiOperation("Listar motos")
    public List<DtoMoto> listar() {
        return this.manejadorListarMoto.ejecutar();
    }

}
