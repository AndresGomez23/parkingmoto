package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Moto;

import java.time.LocalDateTime;

public class MotoTestDataBuilder {

    private String placa;
    private String cilindraje;
    private int casco;
    private LocalDateTime fechaIngreso;

    public MotoTestDataBuilder() {
        placa = "AAO71F";
        cilindraje = "102";
        casco = 2;
    }

    public MotoTestDataBuilder conCasco(int casco) {
        this.casco = casco;
        return this;
    }

    public MotoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }


    public MotoTestDataBuilder conCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public Moto build() {
        return new Moto(placa,cilindraje,casco,fechaIngreso);
    }
}
