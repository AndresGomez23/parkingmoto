package com.ceiba.moto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

public class ServicioActualizarMoto {

    private static final String LA_MOTO_EXIXTE_EN_EL_SISTEMA = "La moto existe en el sistema";

    private final RepositorioMoto repositorioMoto;

    public ServicioActualizarMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public void ejecutar(Moto moto) {
        validarExistenciaPrevia(moto);
        this.repositorioMoto.actualizar(moto);
    }

    private void validarExistenciaPrevia(Moto moto) {
        boolean existe = this.repositorioMoto.existe(moto.getPlaca());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_MOTO_EXIXTE_EN_EL_SISTEMA);
        }
    }
}
