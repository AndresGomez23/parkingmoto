package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioMoto;
import com.ceiba.usuario.servicio.ServicioActualizarMoto;
import com.ceiba.usuario.servicio.ServicioCrearMoto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearMoto servicioCrearMoto(RepositorioMoto repositorioMoto) {
        return new ServicioCrearMoto(repositorioMoto);
    }

    @Bean
    public ServicioActualizarMoto servicioActualizarMoto(RepositorioMoto repositorioMoto) {
        return new ServicioActualizarMoto(repositorioMoto);
    }
	

}
