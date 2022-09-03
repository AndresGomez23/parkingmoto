package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoMoto;
import com.ceiba.usuario.puerto.dao.DaoMoto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaPorPlaca {
    private final DaoMoto daoMoto;

    public ManejadorConsultaPorPlaca(DaoMoto daoMoto){
        this.daoMoto = daoMoto;
    }

    public DtoMoto ejecutar(String placa){
        return this.daoMoto.obtenerPorPlaca(placa).orElse(null);
    }
}
