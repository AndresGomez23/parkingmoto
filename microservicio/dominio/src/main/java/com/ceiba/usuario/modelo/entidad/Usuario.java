package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La placa debe tener una longitud igual a %s";
    private static final String SE_DEBE_INGRESAR_EL_CILINDRAJE = "Se debe ingresar el cilindraje";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final int LONGITUD_MINIMA_CLAVE = 6;

    private String placa;
    private int casco;
    private String cilindraje;
    private LocalDateTime fechaIngreso;

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;

    public Usuario(Long id,String nombre, String clave,LocalDateTime fechaIngreso) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(clave, SE_DEBE_INGRESAR_EL_CILINDRAJE);
        validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.placa = placa;
        this.casco = casco;
        this.cilindraje = cilindraje;
        this.fechaIngreso = fechaIngreso;
    }

}
