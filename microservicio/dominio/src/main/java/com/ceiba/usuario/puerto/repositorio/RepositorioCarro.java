package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Carro;

public interface RepositorioCarro {

    String crearCarro(Carro carro);

    void actualizarCarro(Carro carro);

    boolean existeCarro(String placa);
}
