package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoMoto;
import com.ceiba.usuario.modelo.entidad.Moto;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
public class FabricaMoto {

    public Moto crear(ComandoMoto comandoMoto) {
        return new Moto(
                comandoMoto.getPlaca(),
                comandoMoto.getCilindraje(),
                comandoMoto.getCasco(),
                LocalDateTime.now()
        );
    }
}