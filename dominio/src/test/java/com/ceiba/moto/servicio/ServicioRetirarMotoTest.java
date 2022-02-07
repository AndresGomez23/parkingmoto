package com.ceiba.moto.servicio;

import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioRetirarMotoTest {

    @Test
    @DisplayName("Deberia retirar la moto llamando al repositorio")
    void deberiaEliminarLaMotoLlamandoAlRepositorio() {
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        ServicioRetirarMoto servicioRetirarMoto = new ServicioRetirarMoto(repositorioMoto);

        servicioRetirarMoto.ejecutar("AAO71F");

        Mockito.verify(repositorioMoto, Mockito.times(1)).retirar("AAO71F");

    }

}
