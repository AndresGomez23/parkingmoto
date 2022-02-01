package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.usuario.modelo.entidad.Moto;
import com.ceiba.usuario.puerto.repositorio.RepositorioMoto;
import com.ceiba.usuario.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearMotoTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la longitud de la placa sea menor de 6")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaPlacaSeaMenorDeSeis() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conPlaca("AAOF71F");
        // act - assert
        BasePrueba.assertThrows(motoTestDataBuilder::build, ExcepcionLongitudValor.class, "La moto debe de tener en la placa una longitud igual o mayor a 6");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la moto")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeLaMoto() {
        // arrange
        Moto moto = new MotoTestDataBuilder().build();
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        Mockito.when(repositorioMoto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearMoto servicioCrearMoto = new ServicioCrearMoto(repositorioMoto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearMoto.ejecutar(moto), ExcepcionDuplicidad.class,"La moto ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear la moto de manera correcta")
    void deberiaCrearLaMotoDeManeraCorrecta() {
        // arrange
        Moto moto = new MotoTestDataBuilder().build();
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        Mockito.when(repositorioMoto.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioMoto.crear(moto)).thenReturn("AAO71F");
        ServicioCrearMoto servicioCrearMoto = new ServicioCrearMoto(repositorioMoto);
        // act
        String placaMoto = servicioCrearMoto.ejecutar(moto);
        //- assert
        assertEquals(10L,placaMoto);
        Mockito.verify(repositorioMoto, Mockito.times(1)).crear(moto);
    }
}

