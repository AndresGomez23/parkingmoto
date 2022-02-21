package com.ceiba.moto.servicio;

import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

import java.util.Date;

public class ServicioLiquidarMoto {
    public long dias;
    public long horas;
    public long minutos;
    public long segundos;

    public ServicioLiquidarMoto(RepositorioMoto repositorioMoto){

    }

    public ServicioLiquidarMoto(long dias, long horas, long minutos, long segundos){
        super();
        this.dias = dias;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void calcularLiquidacionDeMoto(Date fechaIngreso, Date fechaSalida){

        long tiempo = fechaIngreso.getTime() - fechaSalida.getTime();

        long formatoSegundos = 1000;
        long formatoMinutos = formatoSegundos * 60;
        long formatoHoras = formatoMinutos * 60;
        long formatoDias = formatoHoras * 24;

        this.dias = tiempo / formatoDias;
        tiempo = tiempo % formatoDias;

        this.horas = tiempo / formatoHoras;
        tiempo = tiempo % formatoHoras;

        this.minutos = tiempo / formatoMinutos;
        tiempo = tiempo % formatoMinutos;

        this.segundos = tiempo / formatoSegundos;

        aleatorio();

    }

    private void aleatorio(){
        this.minutos += (this.segundos > 0 ? 1 : 0);
        this.horas += (this.minutos > 0 ? 1 : 0);
    }

    public class PagoDeMoto {
        private static final double PRECIO_REGISTRO_MOVIMIENTO = 0;
        private static final double PRECIO_POR_DIA = 8000;
        private static final double PRECIO_POR_HORAS = 1500;


        public void Pago(ServicioLiquidarMoto servicioLiquidarMoto, Moto moto) {
            double precio = PRECIO_REGISTRO_MOVIMIENTO;

            precio += PRECIO_POR_DIA * servicioLiquidarMoto.dias;
            precio += PRECIO_POR_HORAS * servicioLiquidarMoto.horas;


        }
    }
}

