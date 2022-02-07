package com.ceiba.moto.puerto.dao;

import com.ceiba.moto.modelo.dto.DtoMoto;

import java.util.List;

public interface DaoMoto {

    /**
     * Permite listar motos
     * @return las motos
     */
    List<DtoMoto> listar();
}
