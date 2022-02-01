package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Moto;
import com.ceiba.usuario.puerto.repositorio.RepositorioMoto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearMoto {

    private static final String LA_MOTO_YA_EXISTE_EN_EL_SISTEMA = "La moto ya existe en el sistema";

    private final RepositorioMoto repositorioMoto;

    public ServicioCrearMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public String ejecutar(Moto moto) {
        validarExistenciaPrevia(moto);
        return this.repositorioMoto.crear(moto);

    }

    private void validarExistenciaPrevia(Moto moto) {
        boolean existe = this.repositorioMoto.existe(moto.getPlaca());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_MOTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
