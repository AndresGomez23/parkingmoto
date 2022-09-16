package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCarro {
    private String placa;
    private String cilindraje;
    private LocalDateTime fechaIngreso;
}
