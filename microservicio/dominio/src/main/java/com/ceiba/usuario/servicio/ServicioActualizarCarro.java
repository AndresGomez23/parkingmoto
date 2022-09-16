package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Carro;
import com.ceiba.usuario.modelo.entidad.Moto;
import com.ceiba.usuario.puerto.repositorio.RepositorioCarro;

public class ServicioActualizarCarro {

    private static final String EL_CARRO_EXIXTE_EN_EL_SISTEMA = "El carro existe en el sistema";

    private final RepositorioCarro repositorioCarro;

    public ServicioActualizarCarro(RepositorioCarro repositorioCarro) {
        this.repositorioCarro = repositorioCarro;
    }

    public void ejecutar(Carro carro) {
        validarExistenciaPrevia(carro);
        this.repositorioCarro.actualizarCarro(carro);
    }

    private void validarExistenciaPrevia(Carro carro) {
        boolean existe = this.repositorioCarro.existeCarro(carro.getPlaca());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_CARRO_EXIXTE_EN_EL_SISTEMA);
        }
    }
}
