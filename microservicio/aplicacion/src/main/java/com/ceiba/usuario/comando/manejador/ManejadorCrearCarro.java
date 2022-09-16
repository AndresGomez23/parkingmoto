package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCarro;
import com.ceiba.usuario.comando.fabrica.FabricaCarro;
import com.ceiba.usuario.modelo.entidad.Carro;
import com.ceiba.usuario.servicio.ServicioCrearCarro;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCarro implements ManejadorComandoRespuesta<ComandoCarro, ComandoRespuesta<String>> {
    private final FabricaCarro fabricaCarro;
    private final ServicioCrearCarro servicioCrearCarro;

    public ManejadorCrearCarro(FabricaCarro fabricaCarro, ServicioCrearCarro servicioCrearCarro) {
        this.fabricaCarro = fabricaCarro;
        this.servicioCrearCarro = servicioCrearCarro;
    }

    public ComandoRespuesta<String> ejecutar(ComandoCarro comandoCarro) {
        Carro carro = this.fabricaCarro.crearCarro(comandoCarro);
        return new ComandoRespuesta<String>(this.servicioCrearCarro.ejecutar(carro));
    }

}
