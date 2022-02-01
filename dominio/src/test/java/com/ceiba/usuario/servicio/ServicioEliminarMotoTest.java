package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioMoto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarMotoTest {

    @Test
    @DisplayName("Deberia eliminar la moto llamando al repositorio")
    void deberiaEliminarLaMotoLlamandoAlRepositorio() {
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        ServicioEliminarMoto servicioEliminarMoto = new ServicioEliminarMoto(repositorioMoto);

        servicioEliminarMoto.ejecutar("AAO71F");

        Mockito.verify(repositorioMoto, Mockito.times(1)).eliminar("AAO71F");

    }

}
