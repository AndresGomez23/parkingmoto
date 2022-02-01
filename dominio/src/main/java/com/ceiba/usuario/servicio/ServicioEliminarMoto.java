package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioMoto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioEliminarMoto {

    private static final String LA_MOTO_NO_EXISTE= "La moto no se encuentra en el sistema";

    private final RepositorioMoto repositorioMoto;

    public ServicioEliminarMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public String ejecutar(String placa) {
        validarExistenciaPrevia(placa);
        return this.repositorioMoto.eliminar(placa);
    }

    private void validarExistenciaPrevia(String placa) {
        boolean existe = this.repositorioMoto.existe(placa);
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_MOTO_NO_EXISTE);
        }
    }
}