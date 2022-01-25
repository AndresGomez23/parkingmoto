package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.fabrica.FabricaMoto;
import com.ceiba.usuario.modelo.entidad.Moto;
import org.springframework.stereotype.Component;
import com.ceiba.usuario.servicio.ServicioActualizarMoto;

import com.ceiba.usuario.comando.ComandoMoto;


@Component
public class ManejadorActualizarMoto implements ManejadorComando<ComandoMoto> {

    private final FabricaMoto fabricaMoto;
    private final ServicioActualizarMoto servicioActualizarMoto;

    public ManejadorActualizarMoto(FabricaMoto fabricaMoto, ServicioActualizarMoto servicioActualizarMoto) {
        this.fabricaMoto = fabricaMoto;
        this.servicioActualizarMoto = servicioActualizarMoto;
    }

    public void ejecutar(ComandoMoto comandoMoto) {
        Moto moto = this.fabricaMoto.crear(comandoMoto);
        this.servicioActualizarMoto.ejecutar(moto);
    }
}
