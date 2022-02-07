package com.ceiba.moto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;


public class ServicioIngresarMoto {

    private static final String LA_MOTO_YA_EXISTE_EN_EL_SISTEMA = "La moto ya existe en el sistema";

    private final RepositorioMoto repositorioMoto;

    public ServicioIngresarMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public String ejecutar(Moto moto) {
        validarExistenciaPrevia(moto);
        return this.repositorioMoto.ingresar(moto);

    }

    private void validarExistenciaPrevia(Moto moto) {
        boolean existe = this.repositorioMoto.existe(moto.getPlaca());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_MOTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
