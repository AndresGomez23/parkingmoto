package com.ceiba.usuario.controlador;
import java.util.List;

import com.ceiba.usuario.consulta.ManejadorConsultaPorPlaca;
import com.ceiba.usuario.consulta.ManejadorListarMoto;
import com.ceiba.usuario.modelo.dto.DtoMoto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/moto")
@Api(tags={"Controlador consulta motos"})
public class ConsultaControladorMoto {

    private final ManejadorListarMoto manejadorListarMoto;
    private final ManejadorConsultaPorPlaca manejadorConsultaPorPlaca;
    public ConsultaControladorMoto(ManejadorListarMoto manejadorListarMoto,
                                   ManejadorConsultaPorPlaca manejadorConsultaPorPlaca) {
        this.manejadorListarMoto = manejadorListarMoto;
        this.manejadorConsultaPorPlaca = manejadorConsultaPorPlaca;
    }
    @GetMapping(value = "/all")
    @ApiOperation("Listar motos")
    public List<DtoMoto> listar() {
        return this.manejadorListarMoto.ejecutar();
    }

    @GetMapping(value = "/por-placa/{placa}")
    @ApiOperation("va a consultar una moto por placa")
    public DtoMoto obtenerPorMoto(@PathParam("placa") String placa) {
        return this.manejadorConsultaPorPlaca.ejecutar(placa);
    }
}

