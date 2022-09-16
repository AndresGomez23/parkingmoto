package com.ceiba.usuario.controlador;
import java.util.List;


import com.ceiba.usuario.consulta.ManejadorConsultaPorFiltro;
import com.ceiba.usuario.consulta.ManejadorConsultaPorPlaca;
import com.ceiba.usuario.consulta.ManejadorListarMoto;
import com.ceiba.usuario.modelo.dto.DtoMoto;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/moto")
@Api(tags={"Controlador consulta motos"})
public class ConsultaControladorMoto {

    private final ManejadorListarMoto manejadorListarMoto;
    private final ManejadorConsultaPorPlaca manejadorConsultaPorPlaca;
    private final ManejadorConsultaPorFiltro manejadorConsultaPorFiltro;
    public ConsultaControladorMoto(ManejadorListarMoto manejadorListarMoto,
                                   ManejadorConsultaPorPlaca manejadorConsultaPorPlaca,
                                   ManejadorConsultaPorFiltro manejadorConsultaPorFiltro) {
        this.manejadorListarMoto = manejadorListarMoto;
        this.manejadorConsultaPorPlaca = manejadorConsultaPorPlaca;
        this.manejadorConsultaPorFiltro = manejadorConsultaPorFiltro;
    }
    @GetMapping(value = "/all")
    @ApiOperation("Listar motos")
    public List<DtoMoto> listar() {
        return this.manejadorListarMoto.ejecutar();
    }

    @GetMapping(value = "/por-placa/{placa}")
    @ApiOperation("va a consultar una moto por placa")
    public DtoMoto obtenerPorMoto(@PathVariable("placa") String placa) {
        return this.manejadorConsultaPorPlaca.ejecutar(placa);
    }

    @GetMapping(value = "/por-filtro/{placa}")
    @ApiOperation("va a consultar por filtro")
    public List<DtoMoto> obtenerPorFiltro(@PathVariable("placa") String placa) {
        return this.manejadorConsultaPorFiltro.ejecutar(placa);
    }
}

