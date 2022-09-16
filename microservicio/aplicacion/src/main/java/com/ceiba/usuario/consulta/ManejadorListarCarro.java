package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoCarro;
import com.ceiba.usuario.puerto.dao.DaoCarro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCarro {

    private final DaoCarro daoCarro;

    public ManejadorListarCarro(DaoCarro daoCarro){this.daoCarro = daoCarro;}

    public List<DtoCarro> ejecutar(){return this.daoCarro.listarCarro();}


}
