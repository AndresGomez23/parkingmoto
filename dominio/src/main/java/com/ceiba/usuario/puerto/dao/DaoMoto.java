package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoMoto;

import java.util.List;

public interface DaoMoto {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoMoto> listar();
}
