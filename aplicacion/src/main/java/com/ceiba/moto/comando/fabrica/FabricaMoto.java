package com.ceiba.moto.comando.fabrica;

import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.modelo.entidad.Moto;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
public class FabricaMoto {

    public Moto ingresoMoto(ComandoMoto comandoMoto) {
        return new Moto(
                comandoMoto.getPlaca(),
                comandoMoto.getCilindraje(),
                comandoMoto.getCasco(),
                LocalDateTime.now()
        );
    }
}