package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Carro;
import com.ceiba.usuario.puerto.repositorio.RepositorioCarro;

public class ServicioCrearCarro {
    private static final String EL_CARRO_YA_EXISTE_EN_EL_SISTEMA = "El carro ya existe en el sistema";
    private final RepositorioCarro repositorioCarro;
    public ServicioCrearCarro(RepositorioCarro repositorioCarro) {
        this.repositorioCarro = repositorioCarro;
    }

    public String ejecutar(Carro carro) {
        validarExistenciaPrevia(carro);
        return this.repositorioCarro.crearCarro(carro);

    }

    private void validarExistenciaPrevia(Carro carro) {
        boolean existeCarro = this.repositorioCarro.existeCarro(carro.getPlaca());
        if(existeCarro) {
            throw new ExcepcionDuplicidad(EL_CARRO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
