package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoCarro;
import com.ceiba.usuario.modelo.dto.DtoMoto;
import com.ceiba.usuario.puerto.dao.DaoCarro;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaPorPlacaCarro {
    private final DaoCarro daoCarro;

    public ManejadorConsultaPorPlacaCarro(DaoCarro daoCarro){
        this.daoCarro = daoCarro;
    }

    public DtoCarro ejecutar(String placa){
        return this.daoCarro.obtenerPorPlacaCarro(placa).orElse(null);
    }


}
