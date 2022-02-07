package com.ceiba.moto.servicio;

import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioRetirarMoto {

    private static final String LA_MOTO_NO_EXISTE= "La moto no se encuentra en el sistema";

    private final RepositorioMoto repositorioMoto;

    public ServicioRetirarMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public String ejecutar(String placa) {
        validarExistenciaPrevia(placa);
        return this.repositorioMoto.retirar(placa);
    }

    private void validarExistenciaPrevia(String placa) {
        boolean existe = this.repositorioMoto.existe(placa);
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_MOTO_NO_EXISTE);
        }
    }
}