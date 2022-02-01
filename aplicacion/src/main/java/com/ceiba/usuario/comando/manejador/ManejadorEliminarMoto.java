package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarMoto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarMoto implements ManejadorComando<String>{

    private final ServicioEliminarMoto servicioEliminarMoto;

    public ManejadorEliminarMoto(ServicioEliminarMoto servicioEliminarMoto) {
        this.servicioEliminarMoto = servicioEliminarMoto;
    }
    public void ejecutar(String placa) {
        this.servicioEliminarMoto.ejecutar(placa);
    }
}