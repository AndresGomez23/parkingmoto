package com.ceiba.moto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.moto.servicio.ServicioRetirarMoto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorRetirarMoto implements ManejadorComando<String>{

    private final ServicioRetirarMoto servicioRetirarMoto;

    public ManejadorRetirarMoto(ServicioRetirarMoto servicioRetirarMoto) {
        this.servicioRetirarMoto = servicioRetirarMoto;
    }
    public void ejecutar(String placa) {
        this.servicioRetirarMoto.ejecutar(placa);
    }
}