package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioCarro;
import com.ceiba.usuario.puerto.repositorio.RepositorioMoto;
import com.ceiba.usuario.servicio.ServicioActualizarCarro;
import com.ceiba.usuario.servicio.ServicioActualizarMoto;
import com.ceiba.usuario.servicio.ServicioCrearCarro;
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

    @Bean
    public ServicioCrearCarro servicioCrearCarro(RepositorioCarro repositorioCarro) {
        return new ServicioCrearCarro(repositorioCarro);
    }

    @Bean
    public ServicioActualizarCarro servicioActualizarCarro(RepositorioCarro repositorioCarro) {
        return new ServicioActualizarCarro(repositorioCarro);
    }

}
