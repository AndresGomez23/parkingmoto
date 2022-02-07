package com.ceiba.moto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.moto.comando.fabrica.FabricaMoto;
import com.ceiba.moto.modelo.entidad.Moto;
import org.springframework.stereotype.Component;
import com.ceiba.moto.servicio.ServicioActualizarMoto;

import com.ceiba.moto.comando.ComandoMoto;


@Component
public class ManejadorActualizarMoto implements ManejadorComando<ComandoMoto> {

    private final FabricaMoto fabricaMoto;
    private final ServicioActualizarMoto servicioActualizarMoto;

    public ManejadorActualizarMoto(FabricaMoto fabricaMoto, ServicioActualizarMoto servicioActualizarMoto) {
        this.fabricaMoto = fabricaMoto;
        this.servicioActualizarMoto = servicioActualizarMoto;
    }

    public void ejecutar(ComandoMoto comandoMoto) {
        Moto moto = this.fabricaMoto.ingresoMoto(comandoMoto);
        this.servicioActualizarMoto.ejecutar(moto);
    }
}
