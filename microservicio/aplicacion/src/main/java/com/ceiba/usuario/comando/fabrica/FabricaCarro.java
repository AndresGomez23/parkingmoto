package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoCarro;
import com.ceiba.usuario.modelo.entidad.Carro;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaCarro {

    public Carro crearCarro(ComandoCarro comandoCarro) {
        return new Carro(
                comandoCarro.getPlaca(),
                comandoCarro.getCilindraje(),
                LocalDateTime.now()
        );
    }
}
