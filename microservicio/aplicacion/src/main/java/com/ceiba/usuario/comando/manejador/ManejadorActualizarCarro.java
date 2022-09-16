package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.ComandoCarro;
import com.ceiba.usuario.comando.fabrica.FabricaCarro;
import com.ceiba.usuario.modelo.entidad.Carro;
import com.ceiba.usuario.servicio.ServicioActualizarCarro;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCarro implements ManejadorComando<ComandoCarro> {
    private final FabricaCarro fabricaCarro;
    private final ServicioActualizarCarro servicioActualizarCarro;

    public ManejadorActualizarCarro(FabricaCarro fabricaCarro, ServicioActualizarCarro servicioActualizarCarro) {
        this.fabricaCarro = fabricaCarro;
        this.servicioActualizarCarro = servicioActualizarCarro;
    }

    public void ejecutar(ComandoCarro comandoCarro) {
        Carro carro = this.fabricaCarro.crearCarro(comandoCarro);
        this.servicioActualizarCarro.ejecutar(carro);
    }
}
