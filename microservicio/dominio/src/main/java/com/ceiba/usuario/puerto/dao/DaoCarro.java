package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoCarro;

import java.util.List;
import java.util.Optional;

public interface DaoCarro {

    List<DtoCarro> listarCarro();
    Optional<DtoCarro> obtenerPorPlacaCarro(String placa);
    List<DtoCarro> obtenerPorFiltroCarro(String placa);
}
