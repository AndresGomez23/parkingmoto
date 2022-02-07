package com.ceiba.moto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioIngresarMotoTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la longitud de la placa sea menor de 5")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaPlacaSeaMenorDeCinco() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conPlaca("AAO71F");
        // act - assert
        BasePrueba.assertThrows(motoTestDataBuilder::build, ExcepcionLongitudValor.class, "La moto debe de tener en la placa una longitud igual o mayor a 5");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la moto")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeLaMoto() {
        // arrange
        Moto moto = new MotoTestDataBuilder().build();
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        Mockito.when(repositorioMoto.existe(Mockito.anyString())).thenReturn(true);
        ServicioIngresarMoto servicioIngresarMoto = new ServicioIngresarMoto(repositorioMoto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioIngresarMoto.ejecutar(moto), ExcepcionDuplicidad.class,"La moto ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia ingresar la moto de manera correcta")
    void deberiaCrearLaMotoDeManeraCorrecta() {
        // arrange
        Moto moto = new MotoTestDataBuilder().build();
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        Mockito.when(repositorioMoto.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioMoto.ingresar(moto)).thenReturn("AAO71F");
        ServicioIngresarMoto servicioIngresarMoto = new ServicioIngresarMoto(repositorioMoto);
        // act
        String placaMoto = servicioIngresarMoto.ejecutar(moto);
        //- assert
        assertEquals(10L,placaMoto);
        Mockito.verify(repositorioMoto, Mockito.times(1)).ingresar(moto);
    }
}

