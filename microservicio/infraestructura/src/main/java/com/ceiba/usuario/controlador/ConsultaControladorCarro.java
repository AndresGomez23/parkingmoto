package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ManejadorConsultaPorFiltroCarro;
import com.ceiba.usuario.consulta.ManejadorConsultaPorPlacaCarro;
import com.ceiba.usuario.consulta.ManejadorListarCarro;
import com.ceiba.usuario.modelo.dto.DtoCarro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/carro")
@Api(tags={"Controlador consulta carros"})
public class ConsultaControladorCarro {
    private final ManejadorListarCarro manejadorListarCarro;
    private final ManejadorConsultaPorPlacaCarro manejadorConsultaPorPlacaCarro;
    private final ManejadorConsultaPorFiltroCarro manejadorConsultaPorFiltroCarro;

    public ConsultaControladorCarro(ManejadorListarCarro manejadorListarCarro,
                                    ManejadorConsultaPorPlacaCarro manejadorConsultaPorPlacaCarro,
                                    ManejadorConsultaPorFiltroCarro manejadorConsultaPorFiltroCarro) {
        this.manejadorListarCarro = manejadorListarCarro;
        this.manejadorConsultaPorPlacaCarro = manejadorConsultaPorPlacaCarro;
        this.manejadorConsultaPorFiltroCarro = manejadorConsultaPorFiltroCarro;
    }

    @GetMapping(value = "/all")
    @ApiOperation("Listar carros")
    public List<DtoCarro> listarCarro() {
        return this.manejadorListarCarro.ejecutar();
    }

    @GetMapping(value = "/por-placa/{placa}")
    @ApiOperation("va a consultar un carro por placa")
    public DtoCarro obtenerPorCarro(@PathVariable("placa") String placa) {
        return this.manejadorConsultaPorPlacaCarro.ejecutar(placa);
    }

    @GetMapping(value = "/por-filtro/{placa}")
    @ApiOperation("va a consultar por filtro")
    public List<DtoCarro> obtenerPorFiltro(@PathVariable("placa") String placa) {
        return this.manejadorConsultaPorFiltroCarro.ejecutar(placa);
    }


}
