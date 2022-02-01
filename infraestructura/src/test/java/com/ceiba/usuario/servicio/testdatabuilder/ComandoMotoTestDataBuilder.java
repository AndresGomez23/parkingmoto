package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoMoto;

public class ComandoMotoTestDataBuilder {

    private String placa;
    private String cilindraje;
    private int casco;

    public ComandoMotoTestDataBuilder() {
        placa = "AAO71F";
        cilindraje = "99";
        casco = 1;
    }

    public ComandoMotoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ComandoMoto build() {
        return new ComandoMoto(placa,cilindraje,casco);
    }
}
