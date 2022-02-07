package com.ceiba.moto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.Test;

public class MotoTest {


    @Test
    void deberiaFallarSinPlacaDeMoto() {

        //Arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conPlaca(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    motoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la placa de la moto");
    }

    @Test
    void deberiaFallarPorLaLongitudPlaca() {

        //Arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conPlaca("a4s5");
        //act-assert
        BasePrueba.assertThrows(() -> {
                    motoTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "La placa debe tener una longitud igual a 5");
    }


    @Test
    void deberiaFallarSinCilindraje() {

        //Arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conCilindraje(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    motoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el cilindraje");
    }

}
