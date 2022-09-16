package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoCarro;
import com.ceiba.usuario.modelo.dto.DtoMoto;
import com.ceiba.usuario.puerto.dao.DaoCarro;
import com.ceiba.usuario.puerto.dao.DaoMoto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultaPorFiltroCarro {
    private final DaoCarro daoCarro;

    public ManejadorConsultaPorFiltroCarro(DaoCarro daoCarro) {this.daoCarro = daoCarro;}

    public List<DtoCarro> ejecutar(String placa){
        return this.daoCarro.obtenerPorFiltroCarro(placa);
    }



}
