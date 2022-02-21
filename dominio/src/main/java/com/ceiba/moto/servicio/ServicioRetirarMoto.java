package com.ceiba.moto.servicio;

import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.Date;



public class ServicioRetirarMoto {

    private static final String LA_MOTO_NO_EXISTE= "La moto no se en cuentra en el sistema";

    private final RepositorioMoto repositorioMoto;
    private final DaoMoto daoMoto;
    private final ServicioLiquidarMoto servicioLiquidarMoto;

    public ServicioRetirarMoto(RepositorioMoto repositorioMoto, ServicioLiquidarMoto servicioLiquidarMoto, DaoMoto daoMoto) {
        this.repositorioMoto = repositorioMoto;
        this.servicioLiquidarMoto = servicioLiquidarMoto;
        this.daoMoto = daoMoto;
    }

    public String ejecutar(String placa) {
        validarExistenciaPrevia(placa);
        LocalDateTime fechaSalida = LocalDateTime.now();
        DtoMoto moto = daoMoto.obtenerMoto(placa);
        Double tarifa = calcularTarifa(Timestamp.valueOf(moto.getFechaIngreso()), Timestamp.valueOf(fechaSalida));
        this.repositorioMoto.retirar(placa);
        return "El valor a pagar de la moto con placa " + placa +  "es de " + tarifa;
    }

    private Double calcularTarifa(Date fechaSalida, Date fechaIngreso) {
        long totalMilisegundos = fechaSalida.getTime() - fechaIngreso.getTime();
        long unaHora = 3600000;
        long calculoHoras = (totalMilisegundos / unaHora);
        double valorPagar = calculoHoras * 1500D;
        return valorPagar;
    }

    private void validarExistenciaPrevia(String placa) {
        boolean existe = this.repositorioMoto.existe(placa);
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_MOTO_NO_EXISTE);
        }
    }
}