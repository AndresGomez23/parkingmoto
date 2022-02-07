package com.ceiba.moto.puerto.repositorio;

import com.ceiba.moto.modelo.entidad.Moto;


public interface RepositorioMoto {
    /**
     * Permite ingresar una moto
     * @param moto
     * @return la placa generado
     */
    String ingresar(Moto moto);

    /**
     * Permite actualizar la placa
     * @param moto
     */
    void actualizar(Moto moto);

    /**
     * Permite retirar la moto
     * @param placa
     */
    String retirar(String placa);

    /**
     * Permite validar si existe la moto con un la placa
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);

}

