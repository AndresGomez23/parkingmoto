package com.ceiba.configuracion;

import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.ServicioActualizarMoto;
import com.ceiba.moto.servicio.ServicioIngresarMoto;
import com.ceiba.moto.servicio.ServicioRetirarMoto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioIngresarMoto servicioIngresarMoto(RepositorioMoto repositorioMoto) {
        return new ServicioIngresarMoto(repositorioMoto);
    }

    @Bean
    public ServicioActualizarMoto servicioActualizarMoto(RepositorioMoto repositorioMoto) {
        return new ServicioActualizarMoto(repositorioMoto);
    }

    @Bean
    public ServicioRetirarMoto servicioRetirarMoto(RepositorioMoto repositorioMoto) {
        return new ServicioRetirarMoto(repositorioMoto);
    }

}
