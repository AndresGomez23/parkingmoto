package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoMoto;

import java.util.List;
import java.util.Optional;

public interface DaoMoto {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoMoto> listar();

    Optional<DtoMoto> obtenerPorPlaca(String placa);
}
