package com.ceiba.moto.servicio;

import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioRetirarMotoTest {

    @Test
    @DisplayName("Deberia retirar la moto llamando al repositorio")
    void deberiaEliminarLaMotoLlamandoAlRepositorio() {
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        ServicioLiquidarMoto servicioLiquidarMoto = Mockito.mock(ServicioLiquidarMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);

        ServicioRetirarMoto servicioRetirarMoto = new ServicioRetirarMoto(repositorioMoto, servicioLiquidarMoto, daoMoto);

        servicioRetirarMoto.ejecutar("AAO71F");

        Mockito.verify(repositorioMoto, Mockito.times(1)).retirar("AAO71F");

    }

}
