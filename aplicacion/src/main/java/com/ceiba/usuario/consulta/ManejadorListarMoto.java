package com.ceiba.usuario.consulta;

import java.util.List;

import com.ceiba.usuario.modelo.dto.DtoMoto;
import com.ceiba.usuario.puerto.dao.DaoMoto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarMoto {

    private final DaoMoto daoMoto;

    public ManejadorListarMoto(DaoMoto daoMoto){
        this.daoMoto = daoMoto;
    }

    public List<DtoMoto> ejecutar(){ return this.daoMoto.listar(); }
}
