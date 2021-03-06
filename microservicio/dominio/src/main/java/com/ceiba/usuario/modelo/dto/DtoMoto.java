package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoMoto {
    private String placa;
    private int casco;
    private String cilindraje;
    private LocalDateTime fechaIngreso;

}
