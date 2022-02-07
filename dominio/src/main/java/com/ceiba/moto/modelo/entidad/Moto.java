package com.ceiba.moto.modelo.entidad;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

    public class Moto {private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La placa debe tener una longitud igual a %s";
    private static final String SE_DEBE_INGRESAR_EL_CILINDRAJE = "Se debe ingresar el cilindraje";
    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa de la moto";

    private static final int LONGITUD_MINIMA_PLACA = 5;

    private String placa;
    private int casco;
    private String cilindraje;
    private LocalDateTime fechaIngreso;

    public Moto(String placa,String cilindraje,int casco, LocalDateTime fechaIngreso) {
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarObligatorio(cilindraje, SE_DEBE_INGRESAR_EL_CILINDRAJE);
        validarLongitud(placa, LONGITUD_MINIMA_PLACA, String.format(LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A,LONGITUD_MINIMA_PLACA));
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.placa = placa;
        this.casco = casco;
        this.cilindraje = cilindraje;
        this.fechaIngreso = fechaIngreso;
    }

        public String getPlaca() {
            return placa;
        }

        public int getCasco() {
            return casco;
        }

        public String getCilindraje() {
            return cilindraje;
        }

        public LocalDateTime getFechaIngreso() {
            return fechaIngreso;
        }
    }

