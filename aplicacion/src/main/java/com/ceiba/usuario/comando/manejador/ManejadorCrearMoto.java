package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoMoto;
import com.ceiba.usuario.comando.fabrica.FabricaMoto;
import com.ceiba.usuario.modelo.entidad.Moto;
import com.ceiba.usuario.servicio.ServicioCrearMoto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearMoto implements ManejadorComandoRespuesta<ComandoMoto, ComandoRespuesta<String>> {

    private final FabricaMoto fabricaMoto;
    private final ServicioCrearMoto servicioCrearMoto;

    public ManejadorCrearMoto(FabricaMoto fabricaMoto, ServicioCrearMoto servicioCrearMoto) {
        this.fabricaMoto = fabricaMoto;
        this.servicioCrearMoto = servicioCrearMoto;
    }

    public ComandoRespuesta<String> ejecutar(ComandoMoto comandoMoto) {
        Moto moto = this.fabricaMoto.crear(comandoMoto);
        return new ComandoRespuesta<String>(this.servicioCrearMoto.ejecutar(moto));
    }
}
