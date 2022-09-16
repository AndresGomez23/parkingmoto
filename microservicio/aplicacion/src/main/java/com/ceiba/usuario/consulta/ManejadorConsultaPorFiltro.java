package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoMoto;
import com.ceiba.usuario.puerto.dao.DaoMoto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultaPorFiltro {
    //instanciar la clase para utilizarla en todo el ciclo de vida de la app
    private final DaoMoto daoMoto;

    public ManejadorConsultaPorFiltro(DaoMoto daoMoto) {this.daoMoto = daoMoto;}

    public List<DtoMoto> ejecutar(String placa){
        return this.daoMoto.obtenerPorFiltro(placa);
    }
}
