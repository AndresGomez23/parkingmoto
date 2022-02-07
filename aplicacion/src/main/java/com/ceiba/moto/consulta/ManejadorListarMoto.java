package com.ceiba.moto.consulta;

import java.util.List;

import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarMoto {

    private final DaoMoto daoMoto;

    public ManejadorListarMoto(DaoMoto daoMoto){
        this.daoMoto = daoMoto;
    }

    public List<DtoMoto> ejecutar(){ return this.daoMoto.listar(); }
}
