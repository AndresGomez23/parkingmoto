package com.ceiba.moto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.comando.fabrica.FabricaMoto;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.servicio.ServicioIngresarMoto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorIngresarMoto implements ManejadorComandoRespuesta<ComandoMoto, ComandoRespuesta<String>> {

    private final FabricaMoto fabricaMoto;
    private final ServicioIngresarMoto servicioIngresarMoto;

    public ManejadorIngresarMoto(FabricaMoto fabricaMoto, ServicioIngresarMoto servicioIngresarMoto) {
        this.fabricaMoto = fabricaMoto;
        this.servicioIngresarMoto = servicioIngresarMoto;
    }

    public ComandoRespuesta<String> ejecutar(ComandoMoto comandoMoto) {
        Moto moto = this.fabricaMoto.ingresoMoto(comandoMoto);
        return new ComandoRespuesta<String>(this.servicioIngresarMoto.ejecutar(moto));
    }
}
